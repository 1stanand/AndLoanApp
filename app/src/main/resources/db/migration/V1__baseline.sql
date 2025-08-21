CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    min_amount NUMERIC(19,2) NOT NULL,
    max_amount NUMERIC(19,2) NOT NULL,
    rate_annual NUMERIC(5,2) NOT NULL,
    term_min INT NOT NULL,
    term_max INT NOT NULL,
    active BOOLEAN DEFAULT TRUE
);

CREATE TABLE customers (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    dob DATE,
    phone VARCHAR(20),
    email VARCHAR(100),
    pan VARCHAR(10) UNIQUE,
    aadhaar VARCHAR(12) UNIQUE,
    address_line1 VARCHAR(255),
    address_line2 VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    pincode VARCHAR(10),
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TYPE application_stage AS ENUM ('LEAD','KYC','APPLICATION','SUBMITTED','APPROVED','DISBURSAL','DISBURSED','REJECTED');

CREATE TABLE applications (
    id BIGSERIAL PRIMARY KEY,
    app_no VARCHAR(30) NOT NULL UNIQUE,
    customer_id BIGINT REFERENCES customers(id),
    product_id BIGINT REFERENCES products(id),
    amount NUMERIC(19,2) NOT NULL,
    tenure INT NOT NULL,
    purpose VARCHAR(255),
    stage application_stage NOT NULL,
    assignee_id BIGINT REFERENCES users(id),
    created_by BIGINT REFERENCES users(id),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    version BIGINT NOT NULL DEFAULT 0
);
