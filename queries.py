import data_manager


def add_user(username, password):
    query = """
        INSERT INTO users VALUES
            (DEFAULT, %(username)s, %(password)s)
        """
    data_manager.execute_select(query, {"username": username,
                                        "password": password},
                                select=False)


def delete_home_owner(home_owner_id):
    query = '''
        DELETE FROM locations
            WHERE home_owner_id = %(home_owner_id)s;
        DELETE FROM services
            WHERE home_owner_id = %(home_owner_id)s;
        DELETE FROM home_owners
            WHERE id = %(home_owner_id)s;
        '''
    data_manager.execute_select(query, {'home_owner_id': home_owner_id}, select=False)


def delete_applicant(applicant_id):
    query = '''
        DELETE FROM locations
            WHERE home_owner_id = %(applicant_id)s;
        DELETE FROM services
            WHERE home_owner_id = %(applicant_id)s;
        DELETE FROM home_owners
            WHERE id = %(applicant_id)s;
        '''
    data_manager.execute_select(query, {'applicant_id': applicant_id}, select=False)


def check_if_user_exists(username):
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


def get_home_owner_id(email):
    query = '''
            SELECT id
            FROM home_owners
            WHERE username = %(email)s
            '''

    return data_manager.execute_select(query, {'email': email}, fetchall=False)


def get_applicant_id(email):
    query = '''
            SELECT id
            FROM users
            WHERE username = %(email)s
            '''

    return data_manager.execute_select(query, {'email': email}, fetchall=False)


def get_location_id(address):
    query = '''
            SELECT id
            FROM users
            WHERE address = %(address)s
            '''

    return data_manager.execute_select(query, {'address': address}, fetchall=False)


def delete_location(id):
    query = '''
            DELETE FROM locations
                WHERE id = %(id)s;
            '''
    return data_manager.execute_select(query, {'id': id}, fetchall=False)


def delete_applicant_location(email):
    query = '''
            DELETE FROM applicants
                WHERE home_id = %(email)s;
            '''
    return data_manager.execute_select(query, {'email': email}, fetchall=False)