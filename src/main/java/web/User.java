package web;
import javax.persistence.*;

@Entity @Table(name="users")
public class User {
	public @Id Long id;
	public String name;
	public String email;
}