import data_manager


def add_user(username, password):
    query = """
        INSERT INTO users VALUES
            (DEFAULT, %(username)s, %(password)s)
        """
    data_manager.execute_select(query, {"username": username,
                                        "password": password},
                                select=False)


def delete_user(user_id):
    query = '''
        DELETE FROM users
        WHERE id = %(user_id)s;
        '''
    data_manager.execute_select(query, {'user_id': user_id}, select=False)


def check_if_user_exists(username):
    query = """
        SELECT EXISTS
        (SELECT *
        FROM users
        WHERE username = %(username)s);
        """

    return data_manager.execute_select(query, {"username": username}, fetchall=False)


def get_user_id(username):
    query = '''
        SELECT id
        FROM users
        WHERE username = %(username)s
        '''

    return data_manager.execute_select(query, {'username': username}, fetchall=False)


def get_user_password(username):
    query = """
        SELECT password
        FROM users
        WHERE username = %(username)s;
        """

    return data_manager.execute_select(query, {"username": username}, fetchall=False)

