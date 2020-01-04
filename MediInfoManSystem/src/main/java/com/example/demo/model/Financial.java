package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.demo.datasecure.EncryptionDecryption;

@Entity
@Table(name="financial_info")
public class Financial {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="financial_id")
	private int id;
	
	
	//income
	
	@Column(name="inc_resource_name1")
	private String inc1_name;
	
	@Column(name="inc_resource_ammount1")
	private float inc1_ammount;
	
	@Column(name="inc_resource_name2")
	private String inc2_name;
	
	@Column(name="inc_resource_ammount2")
	private float inc2_ammount;
	
	@Column(name="inc_resource_name3")
	private String inc3_name;
	
	@Column(name="inc_resource_ammount3")
	private float inc3_ammount;
	
	@Column(name="inc_resource_name4")
	private String inc4_name;
	
	@Column(name="inc_resource_ammount4")
	private float inc4_ammount;
	
	@Column(name="inc_resource_name5")
	private String inc5_name;
	
	@Column(name="inc_resource_ammount5")
	private float inc5_ammount;
	
	@Column(name="inc_resource_name6")
	private String inc6_name;
	
	@Column(name="inc_resource_ammount6")
	private float inc6_ammount;
	
	@Column(name="inc_resource_name7")
	private String inc7_name;
	
	@Column(name="inc_resource_ammount7")
	private float inc7_ammount;
	
	@Column(name="inc_resource_name8")
	private String inc8_name;
	
	@Column(name="inc_resource_ammount8")
	private float inc8_ammount;
	
	@Column(name="inc_resource_name9")
	private String inc9_name;
	
	@Column(name="inc_resource_ammount9")
	private float inc9_ammount;
	
	@Column(name="inc_resource_name10")
	private String inc10_name;
	
	@Column(name="inc_resource_ammount10")
	private float inc10_ammount;
	
	@Column(name="inc_resource_total")
	private float inc_total;
	
	
	
	//expense
	
	@Column(name="exp_resource_name1")
	private String exp1_name;
	
	@Column(name="exp_resource_ammount1")
	private float exp1_ammount;
	
	@Column(name="exp_resource_name2")
	private String exp2_name;
	
	@Column(name="exp_resource_ammount2")
	private float exp2_ammount;
	
	@Column(name="exp_resource_name3")
	private String exp3_name;
	
	@Column(name="exp_resource_ammount3")
	private float exp3_ammount;
	
	@Column(name="exp_resource_name4")
	private String exp4_name;
	
	@Column(name="exp_resource_ammount4")
	private float exp4_ammount;
	
	@Column(name="exp_resource_name5")
	private String exp5_name;
	
	@Column(name="exp_resource_ammount5")
	private float exp5_ammount;
	
	@Column(name="exp_resource_name6")
	private String exp6_name;
	
	@Column(name="exp_resource_ammount6")
	private float exp6_ammount;
	
	@Column(name="exp_resource_name7")
	private String exp7_name;
	
	@Column(name="exp_resource_ammount7")
	private float exp7_ammount;
	
	@Column(name="exp_resource_name8")
	private String exp8_name;
	
	@Column(name="exp_resource_ammount8")
	private float exp8_ammount;
	
	@Column(name="exp_resource_name9")
	private String exp9_name;
	
	@Column(name="exp_resource_ammount9")
	private float exp9_ammount;
	
	@Column(name="exp_resource_name10")
	private String exp10_name;
	
	@Column(name="exp_resource_ammount10")
	private float exp10_ammount;
	
	@Column(name="exp_resource_total")
	private float exp_total;
	
	
	@Column(name="profit")
	private float profit;
	
	@Column(name="loss")
	private float loss;
	
	@NotNull(message = "Create date is compoulsory")
	@Column(name="create_date")
	private String date;
	
	@NotNull(message = "Session information is compoulsory")
	@Column(name="info_session")
	private String session;

	public int getId() {
		return id;
	}
	
	
//income.......................................................................
	public String getInc1_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(inc1_name);
	}

	public float getInc1_ammount() {
		return inc1_ammount;
	}

	public String getInc2_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(inc2_name);
	}

	public float getInc2_ammount() {
		return inc2_ammount;
	}

	public String getInc3_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(inc3_name);
	}

	public float getInc3_ammount() {
		return inc3_ammount;
	}

	public String getInc4_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(inc4_name);
	}

	public float getInc4_ammount() {
		return inc4_ammount;
	}

	public String getInc5_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(inc5_name);
	}

	public float getInc5_ammount() {
		return inc5_ammount;
	}

	public String getInc6_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(inc6_name);
	}

	public float getInc6_ammount() {
		return inc6_ammount;
	}

	public String getInc7_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(inc7_name);
	}

	public float getInc7_ammount() {
		return inc7_ammount;
	}

	public String getInc8_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(inc8_name);
	}

	public float getInc8_ammount() {
		return inc8_ammount;
	}

	public String getInc9_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(inc9_name);
	}

	public float getInc9_ammount() {
		return inc9_ammount;
	}

	public String getInc10_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(inc10_name);
	}

	public float getInc10_ammount() {
		return inc10_ammount;
	}

	public float getInc_total() {
		return inc_total;
	}
   
	//expense...............................
	
	
	public String getExp1_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(exp1_name);
	}

	public float getExp1_ammount() {
		return exp1_ammount;
	}

	public String getExp2_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(exp2_name);
	}

	public float getExp2_ammount() {
		return exp2_ammount;
	}

	public String getExp3_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(exp3_name);
	}

	public float getExp3_ammount() {
		return exp3_ammount;
	}

	public String getExp4_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(exp4_name);
	}

	public float getExp4_ammount() {
		return exp4_ammount;
	}

	public String getExp5_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(exp5_name);
	}

	public float getExp5_ammount() {
		return exp5_ammount;
	}

	public String getExp6_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(exp6_name);
	}

	public float getExp6_ammount() {
		return exp6_ammount;
	}

	public String getExp7_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(exp7_name);
	}

	public float getExp7_ammount() {
		return exp7_ammount;
	}

	public String getExp8_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(exp8_name);
	}

	public float getExp8_ammount() {
		return exp8_ammount;
	}

	public String getExp9_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(exp9_name);
	}

	public float getExp9_ammount() {
		return exp9_ammount;
	}

	public String getExp10_name() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(exp10_name);
	}

	public float getExp10_ammount() {
		return exp10_ammount;
	}

	public float getExp_total() {
		return exp_total;
	}

	public String getDate() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(date);
	}

	public String getSession() {
		EncryptionDecryption decryption=new EncryptionDecryption();
		return decryption.decodeData(session);
	}

	public void setId(int id) {
		this.id = id;
	}
   
	
	//income.......................................
	public void setInc1_name(String inc1_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.inc1_name = encryption.dataEncode(inc1_name);
	}

	public void setInc1_ammount(float inc1_ammount) {
		this.inc1_ammount = inc1_ammount;
	}

	public void setInc2_name(String inc2_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.inc2_name = encryption.dataEncode(inc2_name);
	}

	public void setInc2_ammount(float inc2_ammount) {
		this.inc2_ammount = inc2_ammount;
	}

	public void setInc3_name(String inc3_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.inc3_name = encryption.dataEncode(inc3_name);
	}

	public void setInc3_ammount(float inc3_ammount) {
		this.inc3_ammount = inc3_ammount;
	}

	public void setInc4_name(String inc4_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.inc4_name = encryption.dataEncode(inc4_name);
	}

	public void setInc4_ammount(float inc4_ammount) {
		this.inc4_ammount = inc4_ammount;
	}

	public void setInc5_name(String inc5_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.inc5_name = encryption.dataEncode(inc5_name);
	}

	public void setInc5_ammount(float inc5_ammount) {
		this.inc5_ammount = inc5_ammount;
	}

	public void setInc6_name(String inc6_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.inc6_name = encryption.dataEncode(inc6_name);
	}

	public void setInc6_ammount(float inc6_ammount) {
		this.inc6_ammount = inc6_ammount;
	}

	public void setInc7_name(String inc7_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.inc7_name = encryption.dataEncode(inc7_name);
	}

	public void setInc7_ammount(float inc7_ammount) {
		this.inc7_ammount = inc7_ammount;
	}

	public void setInc8_name(String inc8_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.inc8_name = encryption.dataEncode(inc8_name);
	}

	public void setInc8_ammount(float inc8_ammount) {
		this.inc8_ammount = inc8_ammount;
	}

	public void setInc9_name(String inc9_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.inc9_name = encryption.dataEncode(inc9_name);
	}

	public void setInc9_ammount(float inc9_ammount) {
		this.inc9_ammount = inc9_ammount;
	}

	public void setInc10_name(String inc10_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.inc10_name = encryption.dataEncode(inc10_name);
	}

	public void setInc10_ammount(float inc10_ammount) {
		this.inc10_ammount = inc10_ammount;
	}

	public void setInc_total(float inc_total) {
		this.inc_total = inc_total;
	}

	
	
	//expense........................................................
	public void setExp1_name(String exp1_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.exp1_name = encryption.dataEncode(exp1_name);
	}

	public void setExp1_ammount(float exp1_ammount) {
		this.exp1_ammount = exp1_ammount;
	}

	public void setExp2_name(String exp2_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.exp2_name = encryption.dataEncode(exp2_name);
	}

	public void setExp2_ammount(float exp2_ammount) {
		this.exp2_ammount = exp2_ammount;
	}

	public void setExp3_name(String exp3_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.exp3_name = encryption.dataEncode(exp3_name);
	}

	public void setExp3_ammount(float exp3_ammount) {
		this.exp3_ammount = exp3_ammount;
	}

	public void setExp4_name(String exp4_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.exp4_name = encryption.dataEncode(exp4_name);
	}

	public void setExp4_ammount(float exp4_ammount) {
		this.exp4_ammount = exp4_ammount;
	}

	public void setExp5_name(String exp5_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.exp5_name = encryption.dataEncode(exp5_name);
	}

	public void setExp5_ammount(float exp5_ammount) {
		this.exp5_ammount = exp5_ammount;
	}

	public void setExp6_name(String exp6_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.exp6_name = encryption.dataEncode(exp6_name);
	}

	public void setExp6_ammount(float exp6_ammount) {
		this.exp6_ammount = exp6_ammount;
	}

	public void setExp7_name(String exp7_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.exp7_name = encryption.dataEncode(exp7_name);
	}

	public void setExp7_ammount(float exp7_ammount) {
		this.exp7_ammount = exp7_ammount;
	}

	public void setExp8_name(String exp8_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.exp8_name = encryption.dataEncode(exp8_name);
	}

	public void setExp8_ammount(float exp8_ammount) {
		this.exp8_ammount = exp8_ammount;
	}

	public void setExp9_name(String exp9_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.exp9_name = encryption.dataEncode(exp9_name);
	}

	public void setExp9_ammount(float exp9_ammount) {
		this.exp9_ammount = exp9_ammount;
	}

	public void setExp10_name(String exp10_name) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.exp10_name = encryption.dataEncode(exp10_name);
	}

	public void setExp10_ammount(float exp10_ammount) {
		this.exp10_ammount = exp10_ammount;
	}

	public void setExp_total(float exp_total) {
		this.exp_total = exp_total;
	}

	//other
	public void setDate(String date) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.date = encryption.dataEncode(date);
	}

	public void setSession(String session) {
		EncryptionDecryption encryption=new EncryptionDecryption();
		this.session = encryption.dataEncode(session);
	}


	public float getProfit() {
		return profit;
	}


	public float getLoss() {
		return loss;
	}


	public void setProfit(float profit) {
		this.profit = profit;
	}


	public void setLoss(float loss) {
		this.loss = loss;
	}
}
