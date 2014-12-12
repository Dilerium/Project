package ie.gmit;

public class FibRequest {

	private int JobNum;
	private int max;
	
	public FibRequest(int JobNum, int max){
		this.JobNum = JobNum;
		this.max = max;
	}

	public int getJobNum() {
		return JobNum;
	}

	public void setJobNum(int jobNum) {
		JobNum = jobNum;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
}