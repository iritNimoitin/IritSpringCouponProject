# Spring-Coupon-Project

## About

**Coupon management system** allows companies to generate coupons as part of advertising campaigns
And marketing that they sustain.
The system also has registered customers. Customers can purchase coupons. Coupons are limited in quantity
And in effect. Customer is limited to one coupon of each type.
The system records the coupons purchased by each customer.
The system's income is from purchases of coupons by customers and from creation and updating of new coupons by the companies.

Access to the system is divided into three types of Clients:
1. Administrator - Manage the list of companies and the list of customers.
2. Company - Managing a list of coupons associated with the company.
3. Customer - Purchasing coupons.

### * This project was built on top of a previous project called:
> [Coupons-Project](https://github.com/iritNimoitin/Coupons-Project)

In this project the system will be rebuilt based on Spring and Hibernate technologies.


## Execution stages

 * Part 1 - Transforming the DAO components into Entity Beans equivalent to Java Beans from the previous project.
  
 * Part 2 - Create Spring Repositories with custom queries.
  
 * Part 3 - Transforming the Facades classes from the previous project into Spring Services.
  
 * Part 4 - Turning the CouponExpirationDailyJob and the LoginManager classes into Singletons.
  
 * Part 5 - Building the testing classes to demonstrate the system's capabilities, and operating it from the main.

