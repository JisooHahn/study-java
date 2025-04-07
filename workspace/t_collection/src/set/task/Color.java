package set.task;

import java.util.Objects;

public class Color {
	// 고유 번호
	// 색상
	private Long id;
	private String color;
	
	public Color() {;}

	public Color(Long id, String color) {
		super();
		this.id = id;
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Color [id=" + id + ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Color other = (Color) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
