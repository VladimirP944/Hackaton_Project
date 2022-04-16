import data_manager


def add_user(username, password, photo_id, name, extra_persons, phone_number, type, documents, identity_card):
    query = """
        INSERT INTO users VALUES
            (DEFAULT, %(username)s, %(password)s, %(photo_id)s, %(name)s, %(extra_persons)s, %(phone_number)s, %(type)s, %(documents)s, %(identity_card)s)
        """
    data_manager.execute_select(query, {"username": username,
                                        "password": password,
                                        "photo_id": photo_id,
                                        "name": name,
                                        "extra_persons": extra_persons,
                                        "phone_number": phone_number,
                                        "type": type,
                                        "documents": documents,
                                        "identity_card": identity_card
                                        },
                                select=False)


def delete_user(id):
    query = '''
        DELETE FROM locations
            WHERE user_id = %(id)s;
        DELETE FROM services
            WHERE user_id = %(id)s;
        DELETE FROM users
            WHERE id = %(id)s;
        '''
    data_manager.execute_select(query, {'id': id}, select=False)


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


def get_user_type(username):
    query = '''
            SELECT type
            FROM users
            WHERE username = %(username)s
            '''

    return data_manager.execute_select(query, {'username': username}, fetchall=False)


def add_location(name, description, user_id, address, available_space, total_space, photo_id):
    query = """
            INSERT INTO locations VALUES
                (DEFAULT, %(name)s, %(description)s, %(user_id)s, %(address)s, %(available_space)s, %(total_space)s, %(photo_id)s)
            """
    data_manager.execute_select(query, {"name": name,
                                        "description": description,
                                        "user_id": user_id,
                                        "address": address,
                                        "available_space": available_space,
                                        "total_space": total_space,
                                        "photo_id": photo_id,
                                        },
                                select=False)


def get_all_locations():

    query = '''
            SELECT *
            FROM locations;
            '''

    return data_manager.execute_select(query, fetchall=True)
