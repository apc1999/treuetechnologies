import java.time.LocalDate;

public class Task {
	
	private String title;
    private LocalDate dueDate;
    private String category;
    private int priority;
    private boolean isCompleted;
    
	public Task(String title, LocalDate dueDate, String category, int priority) {
		
		this.title = title;
		this.dueDate = dueDate;
		this.category = category;
		this.priority = priority;
		
	}
	
	public Task() {
		
		
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "Task [title=" + title + ", dueDate=" + dueDate + ", category=" + category + ", priority=" + priority
				+ ", isCompleted=" + isCompleted + "]";
	}
    
    
    
}
