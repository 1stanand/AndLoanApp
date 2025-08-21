INSERT INTO users (username, name, password_hash, role, active)
VALUES
('maker', 'Maker User', '$2a$10$7EqJtq98hPqEX7fNZaFWo.CS0z5kQ81L8lK0pAYX99pYivvXHfve.', 'MAKER', true),
('checker', 'Checker User', '$2a$10$7EqJtq98hPqEX7fNZaFWo.CS0z5kQ81L8lK0pAYX99pYivvXHfve.', 'CHECKER', true);

INSERT INTO products (code, name, min_amount, max_amount, rate_annual, term_min, term_max, active)
VALUES
('EDU', 'Education Loan', 10000, 500000, 8.5, 12, 84, true),
('AUTO', 'Auto Loan', 50000, 1000000, 9.0, 12, 60, true);
