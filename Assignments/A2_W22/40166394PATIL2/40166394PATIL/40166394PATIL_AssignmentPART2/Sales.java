package p2;

import java.util.Date;

/**
 * Sales Class acts as a handler for the Sales records
 * @author rahul
 *
 */
public class Sales {
	
	private String country;
	private String item_type;
	private char order_priority; 
	private Date order_date;
	private long order_ID;
	private Date ship_date;
	private int units_sold;
	private float unit_price;
	private float unit_cost;
	private double revenue; 
	private double total_cost; 
	private double total_profit;
	

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the item_type
	 */
	public String getItem_type() {
		return item_type;
	}

	/**
	 * @param item_type the item_type to set
	 */
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}

	/**
	 * @return the order_priority
	 */
	public char getOrder_priority() {
		return order_priority;
	}

	/**
	 * @param order_priority the order_priority to set
	 */
	public void setOrder_priority(char order_priority) {
		this.order_priority = order_priority;
	}

	/**
	 * @return the order_date
	 */
	public Date getOrder_date() {
		return order_date;
	}

	/**
	 * @param order_date the order_date to set
	 */
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	/**
	 * @return the order_ID
	 */
	public long getOrder_ID() {
		return order_ID;
	}

	/**
	 * @param order_ID the order_ID to set
	 */
	public void setOrder_ID(long order_ID) {
		this.order_ID = order_ID;
	}

	/**
	 * @return the ship_date
	 */
	public Date getShip_date() {
		return ship_date;
	}

	/**
	 * @param ship_date the ship_date to set
	 */
	public void setShip_date(Date ship_date) {
		this.ship_date = ship_date;
	}

	/**
	 * @return the units_sold
	 */
	public int getUnits_sold() {
		return units_sold;
	}

	/**
	 * @param units_sold the units_sold to set
	 */
	public void setUnits_sold(int units_sold) {
		this.units_sold = units_sold;
	}

	/**
	 * @return the unit_price
	 */
	public float getUnit_price() {
		return unit_price;
	}

	/**
	 * @param unit_price the unit_price to set
	 */
	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}

	/**
	 * @return the unit_cost
	 */
	public float getUnit_cost() {
		return unit_cost;
	}

	/**
	 * @param unit_cost the unit_cost to set
	 */
	public void setUnit_cost(float unit_cost) {
		this.unit_cost = unit_cost;
	}

	/**
	 * @return the revenue
	 */
	public double getRevenue() {
		return revenue;
	}

	/**
	 * @param revenue the revenue to set
	 */
	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	/**
	 * @return the total_cost
	 */
	public double getTotal_cost() {
		return total_cost;
	}

	/**
	 * @param total_cost the total_cost to set
	 */
	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}

	/**
	 * @return the total_profit
	 */
	public double getTotal_profit() {
		return total_profit;
	}

	/**
	 * @param total_profit the total_profit to set
	 */
	public void setTotal_profit(double total_profit) {
		this.total_profit = total_profit;
	}
}
