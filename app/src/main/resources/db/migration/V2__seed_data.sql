INSERT INTO users (username,name,password,role,active) VALUES
 ('maker','Maker User','password','MAKER',true),
 ('checker','Checker User','password','CHECKER',true);

INSERT INTO products (code,name,min_amount,max_amount,rate_annual,term_min,term_max,active) VALUES
 ('EDU','Education Loan',10000,500000,10.5,12,60,true),
 ('AUTO','Auto Loan',50000,1000000,9.0,12,84,true);
