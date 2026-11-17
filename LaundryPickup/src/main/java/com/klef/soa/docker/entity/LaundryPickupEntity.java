package com.klef.soa.docker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="laundrypickup_table")
public class LaundryPickupEntity
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Customer name is required")
	@Column(nullable = false)
	private String customerName;

	@NotBlank(message = "Pickup date is required")
	@Column(nullable = false)
	private String pickupDate;

	@NotNull(message = "Weight is required")
	@Positive(message = "Weight must be greater than zero")
	@Column(nullable = false)
	private Double weightKg;

	@NotNull(message = "Delivery status is required")
	@Column(nullable = false)
	private Boolean delivered;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}
	
	public double getWeightKg() {
		return weightKg;
	}
	public void setWeightKg(double weightKg) {
		this.weightKg = weightKg;
	}
	public boolean isDelivered() {
		return delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	@Override
	public String toString() {
		return "LaundryPickupEntity [id=" + id + ", customerName=" + customerName + ", pickupDate=" + pickupDate
				+  " weightKg=" + weightKg + ", delivered=" + delivered + "]";
	}

}
