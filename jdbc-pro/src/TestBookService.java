import java.util.Scanner;
import com.mmcoe.dao.*;
import com.mmcoe.pojo.Book;
import com.mmcoe.service.*;

public class TestBookService {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BookService service = new BookServiceImpl(new BookDaoJdbcImpl());

		int ch;

		do {
			System.out.println("1.Add Book");
			System.out.println("2.Display Books");
			System.out.println("3.Search Book");
			System.out.println("4.Delete Book");
			System.out.println("5.Search By Price");
			System.out.println("9.Exit");
			System.out.print("Enter your choice : ");
			ch = sc.nextInt();

			try {
				switch (ch) {
				case 1:
					System.out.print("ISBN : ");
					int isbn = sc.nextInt();
					sc.nextLine();

					System.out.print("Name : ");
					String name = sc.nextLine();

					System.out.print("Author : ");
					String author = sc.nextLine();

					System.out.print("Price : ");
					double price = sc.nextDouble();

					service.save(new Book(isbn, name, author, price));
					System.out.println("Book Added");
					break;

				case 2:
					service.list().forEach(System.out::println);
					break;

				case 3:
					System.out.print("Enter ISBN : ");
					System.out.println(service.find(sc.nextInt()));
					break;

				case 4:
					System.out.print("Enter ISBN : ");
					service.delete(sc.nextInt());
					System.out.println("Book Deleted");
					break;

				case 5:
					System.out.print("Min Price : ");
					double min = sc.nextDouble();

					System.out.print("Max Price : ");
					double max = sc.nextDouble();

					for (Book b : service.findByPrice(min, max)) {
						System.out.println(b);
					}
					break;
					
				case 9:
					System.out.println("Exit");
					break;
				default:
					System.out.println("Invalid Choice");
				}
			} catch (BookNotFoundException e) {
				System.out.println(e.getMessage());
			}
		} while (ch != 0);

		sc.close();
	}
}