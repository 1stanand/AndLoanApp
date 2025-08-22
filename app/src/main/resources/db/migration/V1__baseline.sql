CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    updated_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE customers (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    dob DATE,
    phone VARCHAR(20),
    email VARCHAR(100),
    pan VARCHAR(10),
    aadhaar VARCHAR(12),
    address_line1 VARCHAR(255),
    address_line2 VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    pincode VARCHAR(20),
    created_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    min_amount NUMERIC(15,2) NOT NULL,
    max_amount NUMERIC(15,2) NOT NULL,
    rate_annual NUMERIC(5,2) NOT NULL,
    term_min INTEGER NOT NULL,
    term_max INTEGER NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TYPE stage AS ENUM ('LEAD','KYC','APPLICATION','SUBMITTED','APPROVED','DISBURSAL','DISBURSED','REJECTED');

CREATE TABLE applications (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT REFERENCES customers(id),
    product_id BIGINT REFERENCES products(id),
    amount NUMERIC(15,2),
    tenure INTEGER,
    purpose VARCHAR(255),
    stage stage NOT NULL,
    assignee_id BIGINT REFERENCES users(id),
    created_by_id BIGINT REFERENCES users(id),
    updated_at TIMESTAMP NOT NULL DEFAULT now(),
    version INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE kyc_documents (
    id BIGSERIAL PRIMARY KEY,
    application_id BIGINT REFERENCES applications(id),
    type VARCHAR(20) NOT NULL,
    file_name VARCHAR(255),
    mime_type VARCHAR(100),
    size BIGINT,
    storage_path VARCHAR(500),
    status VARCHAR(20),
    notes VARCHAR(500),
    uploaded_at TIMESTAMP,
    verified_at TIMESTAMP
);

CREATE TABLE audit_trail (
    id BIGSERIAL PRIMARY KEY,
    app_id BIGINT,
    action VARCHAR(100),
    actor_user BIGINT REFERENCES users(id),
    timestamp TIMESTAMP NOT NULL DEFAULT now(),
    data_json TEXT
);

CREATE TABLE comments (
    id BIGSERIAL PRIMARY KEY,
    app_id BIGINT,
    user_id BIGINT REFERENCES users(id),
    text TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE locks (
    app_id BIGINT PRIMARY KEY,
    user_id BIGINT REFERENCES users(id),
    acquired_at TIMESTAMP NOT NULL,
    expires_at TIMESTAMP NOT NULL
);
