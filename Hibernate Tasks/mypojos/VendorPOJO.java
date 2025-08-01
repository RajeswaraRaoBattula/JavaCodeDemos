package mypojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//One to Many relationship(UNIDIRECTIONAL): One vendor many customers


@Entity
@Table(name="wipro_hib_vendor")//PARENT MYSQL TABLE
public class VendorPOJO 
{
	@Id	
	@Column(name = "vendorno")//primary key
	int vid1;

	@Column(name = "vendorname",length=15)
	String vname1;

	@Column(name = "vendoremail",length=15)
	String vemail;

	/*
	 * When you SHOULDN'T use lazy load:
	 * 
--You have images above the fold. (it delays your header/banner load)
--You have a store. ...
--Have only a few images on each page. ...
--You have a fast-loading website and strong server.

Eager Loading when the relations are not too much. 
Thus, Eager Loading is a good practice to reduce further queries on the Server. 
Use Eager Loading when you are sure that you will be using related entities with the main entity everywhere.
	 */

	/*
	 * | Feature        | Lazy (Default)              | Eager              |
| -------------- | --------------------------- | ------------------ |
| Fetch Time     | When accessed               | Immediately        |
| DB Hits        | Later (on access)           | With parent        |
| Performance    | Efficient (if not accessed) | Slower (if unused) |
| Common With    | `@OneToMany`, `@ManyToOne`  | Same               |
| Exception Risk | LazyInitializationException | None               |

	 */
	
	/*What Does CascadeType.ALL Include?It is a shortcut for:
	 * cascade = {
    CascadeType.PERSIST,
    CascadeType.MERGE,
    CascadeType.REMOVE,
    CascadeType.REFRESH,
    CascadeType.DETACH
}
Use CascadeType.ALL:

When the child lifecycle is 100% dependent on the parent.
	 */
	//fetch = LAZY	Data for customers will only load when you access the collection.
	@OneToMany(fetch=FetchType.LAZY,targetEntity=CustomerPojo.class,cascade=CascadeType.ALL)
	/*
	 * name=>vendorfor_id=>foreign key column in CustomerPojo
	 * referencedColumnName="vendorno"=>primary key in VendorPojo
	 */
	/*
	 * | Use case                      | Suggested                                                                      |
| ----------------------------- | ------------------------------------------------------------------------------ |
| `@ManyToOne`                  | Optional `@JoinColumn` (Hibernate will handle it)                              |
| `@OneToMany` (Unidirectional) | **Always** use `@JoinColumn` to avoid extra join table                         |
| Custom column names           | Must use `@JoinColumn(name="...")` and optionally `referencedColumnName="..."` |

	 */
	
	@JoinColumn(name="vendorfor_id",referencedColumnName="vendorno")//vendorfor_id FOREIGN KEY COLUMN OF CHILD TABLE
	private List<CustomerPojo> customers;

	public List<CustomerPojo> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerPojo> customers) {
		this.customers = customers;
	}

	public int getVid1() {
		return vid1;
	}

	public void setVid1(int vid1) {
		this.vid1 = vid1;
	}

	public String getVname1() {
		return vname1;
	}

	public void setVname1(String vname1) {
		this.vname1 = vname1;
	}

	public String getVemail() {
		return vemail;
	}

	public void setVemail(String vemail) {
		this.vemail = vemail;
	}




}