package com.just.entity;



import java.util.Date;
import java.util.List;

    /**
     * Created by just on 2017/12/4.
     */
    public class Order {
        private int orderId;
        private List<ShoppingCar> shoppingCars;
        private int state;
        private Date orderTime;
        private Address address;
        private User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Address getAddress() {
            return address;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId=" + orderId +
                    ", shoppingCars=" + shoppingCars +
                    ", state=" + state +
                    ", orderTime=" + orderTime +
                    ", address=" + address +
                    '}';
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public List<ShoppingCar> getShoppingCars() {
            return shoppingCars;
        }

        public void setShoppingCars(List<ShoppingCar> shoppingCars) {
            this.shoppingCars = shoppingCars;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public Date getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(Date orderTime) {
            this.orderTime = orderTime;
        }

        public Order() {
        }



}
