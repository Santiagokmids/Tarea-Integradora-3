package model;

public interface Price{

	/** 
        *Name: marketPrice.
        *Calculate the price of the players or main coach's<br> 
        *<b> pre: </b> should is created players or coach's.<br> 
        *<b> post: </b> Price of the players of coach's.
        *@return double. This is the price in the market of the players or coach's.
       */
	public double marketPrice();

}