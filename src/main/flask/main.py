from flask import Flask, render_template, url_for, session, request, flash, redirect, Response
from dotenv import load_dotenv
from werkzeug.security import generate_password_hash
from werkzeug.security import check_password_hash

from util import json_response
import mimetypes
import queries

import json

mimetypes.add_type('application/javascript', '.js')
app = Flask(__name__)
app.secret_key = 'coolHack2'

load_dotenv()


def main():
    app.run(debug=True)

    # Serving the favicon
    with app.app_context():
        app.add_url_rule('/favicon.ico', redirect_to=url_for('static', filename='favicon/favicon.ico'))


if __name__ == '__main__':
    main()
