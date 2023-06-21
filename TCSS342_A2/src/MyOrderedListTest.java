import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyOrderedListTest
{
	private MyOrderedList<Integer> list;
	private UniqueWords un;
	@BeforeEach
	public final void setup()
	{
		list = new MyOrderedList<Integer>();
		un = new UniqueWords();
	}
	
	@Test
	public final void size_0()
	{
		assertEquals(0, list.size(), "size_0 failed");
	}
	
	@Test
	public final void size_1()
	{
		list.add(6);
		assertEquals(1, list.size(), "size_1 failed");
	}
	
	@Test
	public final void is_empty_0()
	{
		assertTrue(list.isEmpty(), "size_0 failed");
	}
	
	@Test
	public final void is_empty_1()
	{
		list.add(6);
		assertFalse(list.isEmpty(), "size_1 failed");
	}
	
	@Test
	public final void add_0()
	{
		list.add(6);
		list.add(2);
		list.add(5);
		list.add(8);
		list.add(0);
		list.add(1);
		list.add(4);
		list.add(7);
		assertEquals("[0, 1, 2, 4, 5, 6, 7, 8]", list.toString(), "size_2 failed");
	}
	
	@Test
	public final void add_1()
	{
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		assertEquals("[0, 1, 2, 3, 4]", list.toString(), "add_1 failed");
	}
	
	@Test
	public final void add_2()
	{
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(0);
		assertEquals("[0, 1, 2, 3, 4]", list.toString(), "add_2 failed");
	}
	
	@Test
	public final void add_3() // work with resize()
	{
		insert_twenty_items(list);
		assertEquals("[0, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 6, 7, 7, 7, 8, 9]", list.toString(), "add_3 failed");
	}
	
	@Test
	public final void unique_words() throws Exception
	{
		assertEquals(true, un.book.book.length() == 3291642 || un.book.book.length() == 3291623, "unique_words failed");
		assertEquals(570240, un.book.words.size(), "unique_words failed");
		un.addUniqueWordsToLinkedList();
		un.addUniqueWordsToArrayList();
		un.addUniqueWordsToOrderedList();
		assertEquals(20228, un.alOfUniqueWords.size(), "unique_words failed");
		assertEquals(20228, un.llOfUniqueWords.size(), "unique_words failed");
		assertEquals(20228, un.olOfUniqueWords.size(), "unique_words failed");
		assertEquals(1065066710, un.alOfUniqueWords.comparisons, "unique_words failed");
		assertEquals(1065066710, un.llOfUniqueWords.comparisons, "unique_words failed");
		assertEquals(114917789, un.olOfUniqueWords.comparisons, "unique_words failed");
	}
	
	// ---------- helper methods ---------
	
	public final void insert_twenty_items(MyOrderedList<Integer> list)
	{
		int array[] = {7, 1, 9, 3, 4, 7, 1, 2, 4, 1, 4, 4, 3, 2, 7, 8, 0, 1, 6, 5};
		for (int index = 0; index < 20; index++)
			list.add(array[index]);
	}
}


