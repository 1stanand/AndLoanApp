INSERT INTO users (username,name,password,role,active) VALUES
 ('maker','Maker User','password','MAKER',true),
 ('checker','Checker User','password','CHECKER',true);

INSERT INTO products (code,name,min_amount,max_amount,rate_annual,term_min,term_max,active) VALUES
 ('EDU','Education Loan',10000,500000,10.5,12,60,true),
 ('AUTO','Auto Loan',50000,1000000,9.0,12,84,true);

INSERT INTO customers (first_name,last_name,pan,aadhaar,created_at) VALUES
 ('John','Doe','ABCDE1234F','123412341234', now());

INSERT INTO applications (customer_id,product_id,amount,tenure,purpose,stage,created_by_id,updated_at)
VALUES (1,1,50000,24,'Education','LEAD',1, now());
