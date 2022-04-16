from functools import wraps
import random
import string
import os

from flask import jsonify


def json_response(func):
    """
    Converts the returned dictionary into a JSON response
    :param func:
    :return:
    """
    @wraps(func)
    def decorated_function(*args, **kwargs):
        return jsonify(func(*args, **kwargs))

    return decorated_function


def generate_id(number_of_small_letters=4,
                number_of_capital_letters=2,
                number_of_digits=2,
                number_of_special_chars=2,
                allowed_special_chars=r"_+-!"):
    id = []

    for small_letter in range(number_of_small_letters):
        id.append(random.choice(string.ascii_lowercase))
    for capital_letter in range(number_of_capital_letters):
        id.append(random.choice(string.ascii_uppercase))
    for digit in range(number_of_digits):
        id.append(str(random.randint(0, 9)))
    for special_char in range(number_of_special_chars):
        id.append(random.choice(allowed_special_chars))

    random.shuffle(id)
    id = ''.join(id)
    return id


def upload_picture(upload_path, file_object):
    output = "No image uploaded"
    if file_object:
        file = file_object
        file.filename = f'{generate_id()}.{((file.filename).split("."))[-1]}'
        while os.path.exists(os.path.join(upload_path, file.filename)):
            file.filename = f'{generate_id()}.{((file.filename).split("."))[-1]}'
        file.save(os.path.join(upload_path, file.filename))
        output = file.filename
    return output


def remove_picture(filename):
    try:
        os.remove(os.path.join(os.path.dirname(__file__), 'static', filename))
    except FileNotFoundError:
        print('File not found - no file deleted')