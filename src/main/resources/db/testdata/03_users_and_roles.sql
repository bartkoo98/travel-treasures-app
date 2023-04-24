INSERT INTO users (email, password) VALUES
    ('admin@email.com', '{noop}1234'),
    ('user@email.com', '{noop}1234');

INSERT INTO user_role (name, description) VALUES
    ('ADMIN', 'pełne uprawnienia'),
    ('USER', 'podstawowe uprawnienia, możliwość zarządzania treściami');

INSERT INTO user_roles (user_id, role_id) VALUES
    (1, 1),
    (2, 2);