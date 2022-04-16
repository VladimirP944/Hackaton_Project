import os

from flask import Flask, render_template, url_for, session, request, flash, redirect, Response
from dotenv import load_dotenv
from werkzeug.security import generate_password_hash
from werkzeug.security import check_password_hash

from util import json_response, upload_picture, remove_picture
import mimetypes
import queries

import json

app = Flask(__name__)
UPLOAD_FOLDER = os.path.join(os.path.dirname(__file__), 'static')
app.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER
mimetypes.add_type('application/javascript', '.js')
app.secret_key = 'coolHack2'

load_dotenv()


@app.route("/", methods=['GET', 'POST'])
def index():
    if "username" not in session:
        return render_template("index.html")
    return render_template("index.html", user=session["username"].split('@')[0].capitalize())


@app.route('/register-applicant', methods=['GET', 'POST'])
def register_user():
    if request.method == 'POST':
        username = request.form.get('username')
        print(request.form.get('username'))
        if not (queries.check_user_exists(username)['exists']):
            password = request.form.get('password')
            hashed_password = generate_password_hash(password)
            name = request.form.get("fname") + " " + request.form.get("Lname")
            extra_persons = request.form.get("extra_persons")
            phone_number = request.form.get("phone_number")
            type = session["type"] if session["type"] else "None"
            identity_card = request.form.get("identity_card")

            if request.files["profile_photo"]:
                photo_id = upload_picture(UPLOAD_FOLDER, request.files["profile_photo"])
            else:
                photo_id = 'avatar.jpg'
            queries.add_user(username, hashed_password, photo_id, name, extra_persons, phone_number, type, identity_card)
            return redirect(url_for("index"))
        flash('User already exists')

    return redirect(url_for("register_user"))


@app.route("/applicant-registration", methods=['GET', 'POST'])
def register_applicant():
    if request.method == 'GET':
        session["type"] = "applicant"
        return render_template("applicant-registration.html")
    else:
        return redirect(url_for("index"))


@app.route("/volunteer-registration", methods=['GET', 'POST'])
def register_volunteer():
    if request.method == 'GET':
        session["type"] = "volunteer"
        return render_template("volunteer-registration.html")
    else:
        return redirect(url_for("index"))


@app.route('/login', methods=['GET', 'POST'])
def check_user_credentials():
    if request.method == 'POST':
        username = request.form.get('username')
        password = request.form.get('password')

        if bool(queries.check_user_exists(username)['exists']):

            hashed_password = queries.get_user_password(username)["password"]
            if check_password_hash(hashed_password, password):
                session['username'] = username
                session['type'] = (queries.get_user_type(username))['type']
                session['user_id'] = (queries.get_user_id(username))['id']
                if session["type"] == "volunteer":
                    return redirect(url_for('get_volunteer_page'))
                return redirect(url_for('get_refugee_page'))
            else:
                flash('Wrong password/user')
        else:
            flash('User does not exist')
    return redirect(url_for("index", user_type=session['type']))


@app.route("/logout")
def logout():
    session.clear()
    return redirect(url_for("index"))


@app.route('/delete_user')
def delete_user():
    queries.delete_user(queries.get_user_id(session['username'])['id'])
    remove_picture(session['profile_picture'])
    session.clear()
    flash('Account Deleted')
    return redirect(url_for("index"))


@app.route('/delete_location')
def delete_location():
    # TODO get address
    # queries.delete_location(queries.get_location_id(address))
    flash('Location Deleted')
    return redirect(url_for("index"))


@app.route('/add-location', methods=['GET', 'POST'])
def add_location():
    if request.method == 'POST':
        name = request.form.get("name")
        description = request.form.get("description")
        user_id = queries.get_user_id(session['username'])['id']
        address = request.form.get("address")
        available_space = request.form.get("space")
        total_space = request.form.get("space")

        if request.files["photo"]:
            photo_id = upload_picture(UPLOAD_FOLDER, request.files["photo"])
        else:
            photo_id = 'None'

        queries.add_location(name, description, user_id, address, available_space, total_space, photo_id)
        return redirect(url_for('get_volunteer_page'))
    else:
        return redirect("index")


@app.route("/all-locations")
def get_all_locations():
    locations = queries.get_all_locations()
    print(locations)
    return render_template("refugees-page.html", locations=locations)


@app.route("/location-registration", methods=['GET', 'POST'])
def register_location():
    if request.method == 'GET':
        return render_template("location-registration.html")
    else:
        return redirect(url_for("index"))


@app.route("/job-registration", methods=['GET', 'POST'])
def register_job():
    if request.method == 'GET':
        return render_template("job-registration.html")
    else:
        return redirect(url_for("index"))


@app.route("/other-help-registration", methods=['GET', 'POST'])
def register_other_help():
    if request.method == 'GET':
        return render_template("other-help-registration.html")
    else:
        return redirect(url_for("index"))


@app.route("/medical-registration", methods=['GET', 'POST'])
def register_medical():
    if request.method == 'GET':
        return render_template("medical-registration.html")
    else:
        return redirect(url_for("index"))


@app.route("/transport-registration", methods=['GET', 'POST'])
def register_transport():
    if request.method == 'GET':
        return render_template("transport-registration.html")
    else:
        return redirect(url_for("index"))


@app.route("/education-registration", methods=['GET', 'POST'])
def register_education():
    if request.method == 'GET':
        return render_template("education-registration.html")
    else:
        return redirect(url_for("index"))


@app.route("/volunteer-page", methods=['GET', 'POST'])
def get_volunteer_page():
    if request.method == 'GET':
        return render_template("volunteers-page.html", user_type=session["type"], name=session["username"])
    else:
        return redirect(url_for("index"))


@app.route("/refugee-page", methods=['GET', 'POST'])
def get_refugee_page():
    if request.method == 'GET':
        return render_template("refugees-page.html", user_type=session["type"], name=session["username"])
    else:
        return redirect(url_for("index"))


def main():
    app.run(debug=True)

    # Serving the favicon
    with app.app_context():
        app.add_url_rule('/favicon.ico', redirect_to=url_for('static', filename='assets/favicon/favicon.png'))


if __name__ == '__main__':
    main()
