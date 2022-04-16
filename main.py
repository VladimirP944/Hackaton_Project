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
def welcome_user():
    if "username" not in session:
        return render_template("index.html")
    return render_template("index.html", user=session["username"].split('@')[0].capitalize())


@app.route('/register', methods=['GET', 'POST'])
def register_user():
    if request.method == 'POST':
        username = request.form.get('username')

        if not (queries.check_if_user_exists(username)['exists']):
            password = request.form.get('password')
            hashed_password = generate_password_hash(password)
            print(request.files["file"])
            if request.files["file"]:
                image_file = upload_picture(UPLOAD_FOLDER, request.files["file"])
            else:
                image_file = 'avatar.jpg'
            queries.add_user(username, hashed_password, image_file)
            return redirect(url_for("register"))
        flash('User already exists')

    return redirect(url_for("register"))


@app.route('/login', methods=['GET', 'POST'])
def check_user_credentials():
    if request.method == 'POST':
        username = request.form.get('username')
        password = request.form.get('password')

        if bool(queries.check_if_user_exists(username)['exists']):

            hashed_password = queries.get_user_password(username)["password"]
            if check_password_hash(hashed_password, password):
                session['username'] = username
                session['user_id'] = (queries.get_user_id(username))['id']
                return redirect(url_for('index'))
            else:
                flash('Wrong password')
        else:
            flash('User does not exist')
    return redirect(url_for("index"))


@app.route("/logout")
def logout():
    session.clear()
    return redirect(url_for("index"))


@app.route('/delete_home_owner')
def delete_user():
    queries.delete_home_owner(queries.get_home_owner_id(session['username'])['id'])
    remove_picture(session['profile_picture'])
    session.clear()
    flash('Account Deleted')
    return redirect(url_for("index"))


@app.route('/delete_applicant')
def delete_user():
    queries.delete_applicant(queries.get_applicant_id(session['username'])['id'])
    remove_picture(session['profile_picture'])
    session.clear()
    flash('Account Deleted')
    return redirect(url_for("index"))


@app.route('/delete_location')
def delete_user():
    # TODO get address
    # queries.delete_location(queries.get_location_id(address))
    flash('Location Deleted')
    return redirect(url_for("index"))


@app.route('/delete_applicant_location')
def delete_user():
    queries.delete_applicant_location(queries.get_applicant_id(session['username'])['id'])
    flash('Home Deleted')
    return redirect(url_for("index"))


@app.route("/api/check-if-user-logged-in")
@json_response
def check_logged_in():
    if 'username' in session:
        return {"response": True}
    return {"response": False}


def main():
    app.run(debug=True)

    # Serving the favicon
    with app.app_context():
        app.add_url_rule('/favicon.ico', redirect_to=url_for('static', filename='assets/favicon/favicon.png'))


if __name__ == '__main__':
    main()
