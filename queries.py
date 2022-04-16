import data_manager


def add_user(username, password, image_file):
    query = """
        INSERT INTO users VALUES
            (DEFAULT, %(username)s, %(password)s, %(photo_id)s)
        """
    data_manager.execute_select(query, {"username": username,
                                        "password": password,
                                        "photo_id": image_file,
                                        },
                                select=False)


def delete_user(user):
    query = '''
        DELETE FROM locations
            WHERE home_owner_id = %(user)s;
        DELETE FROM services
            WHERE home_owner_id = %(user)s;
        DELETE FROM users
            WHERE id = %(user)s;
        '''
    data_manager.execute_select(query, {'user': user}, select=False)


def check_user_exists(username):
    query = """
        SELECT EXISTS
        (SELECT *
        FROM users
        WHERE username = %(username)s);
        """

    return data_manager.execute_select(query, {"username": username}, fetchall=False)


def get_user_password(username):
    query = """
        SELECT password
        FROM users
        WHERE username = %(username)s;
        """

    return data_manager.execute_select(query, {"username": username}, fetchall=False)


def get_user_id(email):
    query = '''
            SELECT id
            FROM users
            WHERE username = %(email)s
            '''

    return data_manager.execute_select(query, {'email': email}, fetchall=False)


def get_location_id(address):
    query = '''
            SELECT id
            FROM locations
            WHERE address = %(address)s
            '''

    return data_manager.execute_select(query, {'address': address}, fetchall=False)


def get_user_services(user_id):
    query = '''
            SELECT *
            FROM services
            WHERE user_id = %(user_id)s
            '''

    return data_manager.execute_select(query, {'user_id': user_id}, fetchall=False)


def get_user_location(user_id):
    query = '''
            SELECT *
            FROM locations
            WHERE user_id = %(user_id)s
            '''

    return data_manager.execute_select(query, {'user_id': user_id}, fetchall=False)


def delete_location(id):
    query = '''
            DELETE FROM locations
                WHERE id = %(id)s;
            '''
    return data_manager.execute_select(query, {'id': id}, fetchall=False)