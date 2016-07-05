package com.pigatron.web.admin.menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class MenuItemTest {

	@Test
	public void testSubmenuBeforeFirst() {
		MenuItem menu = new MenuItem("root", "Root")
				.addSubmenu(new MenuItem("first", "First"))
				.addSubmenu(new MenuItem("second", "Second"))
				.addSubmenu(new MenuItem("third", "third"));

		MenuItem newMenu = new MenuItem("new", "New");
		menu.submenuBefore("first", newMenu);

		assertThat(menu.getSubmenus().size()).isEqualTo(4);
		assertThat(menu.getSubmenus().get(0)).isEqualTo(newMenu);
	}

	@Test
	public void testSubmenuBeforeLast() {
		MenuItem menu = new MenuItem("root", "Root")
				.addSubmenu(new MenuItem("first", "First"))
				.addSubmenu(new MenuItem("second", "Second"))
				.addSubmenu(new MenuItem("third", "third"));

		MenuItem newMenu = new MenuItem("new", "New");
		menu.submenuBefore("third", newMenu);

		assertThat(menu.getSubmenus().size()).isEqualTo(4);
		assertThat(menu.getSubmenus().get(2)).isEqualTo(newMenu);
	}

	@Test
	public void testSubmenuBeforeNotExists() {
		MenuItem menu = new MenuItem("root", "Root")
				.addSubmenu(new MenuItem("first", "First"))
				.addSubmenu(new MenuItem("second", "Second"))
				.addSubmenu(new MenuItem("third", "third"));

		MenuItem newMenu = new MenuItem("new", "New");
		menu.submenuBefore("none", newMenu);

		assertThat(menu.getSubmenus().size()).isEqualTo(4);
		assertThat(menu.getSubmenus().get(3)).isEqualTo(newMenu);
	}

	@Test
	public void testSubmenuAfterFirst() {
		MenuItem menu = new MenuItem("root", "Root")
				.addSubmenu(new MenuItem("first", "First"))
				.addSubmenu(new MenuItem("second", "Second"))
				.addSubmenu(new MenuItem("third", "third"));

		MenuItem newMenu = new MenuItem("new", "New");
		menu.submenuAfter("first", newMenu);

		assertThat(menu.getSubmenus().size()).isEqualTo(4);
		assertThat(menu.getSubmenus().get(1)).isEqualTo(newMenu);
	}

	@Test
	public void testSubmenuAfterLast() {
		MenuItem menu = new MenuItem("root", "Root")
				.addSubmenu(new MenuItem("first", "First"))
				.addSubmenu(new MenuItem("second", "Second"))
				.addSubmenu(new MenuItem("third", "third"));

		MenuItem newMenu = new MenuItem("new", "New");
		menu.submenuAfter("third", newMenu);

		assertThat(menu.getSubmenus().size()).isEqualTo(4);
		assertThat(menu.getSubmenus().get(3)).isEqualTo(newMenu);
	}

	@Test
	public void testSubmenuAfterNotExists() {
		MenuItem menu = new MenuItem("root", "Root")
				.addSubmenu(new MenuItem("first", "First"))
				.addSubmenu(new MenuItem("second", "Second"))
				.addSubmenu(new MenuItem("third", "third"));

		MenuItem newMenu = new MenuItem("new", "New");
		menu.submenuAfter("none", newMenu);

		assertThat(menu.getSubmenus().size()).isEqualTo(4);
		assertThat(menu.getSubmenus().get(0)).isEqualTo(newMenu);
	}

	@Test
	public void testSubmenuMerge() {
		MenuItem menu = new MenuItem("root", "Root")
				.addSubmenu(new MenuItem("first", "First")
						.addSubmenu(new MenuItem("first1", "First1")
								.addSubmenu(new MenuItem("first1sub1", "First1sub1")))
						.addSubmenu(new MenuItem("first2", "First2")))
				.addSubmenu(new MenuItem("second", "Second"))
				.addSubmenu(new MenuItem("third", "third"));

		MenuItem newMenu = new MenuItem("first", "First")
						.addSubmenu(new MenuItem("first1", "First1")
								.addSubmenu(new MenuItem("first1sub2", "First1sub2")))
						.addSubmenu(new MenuItem("first3", "First3"));
		menu.submenu(newMenu);

		assertThat(menu.getSubmenus().get(0).getSubmenus().size()).isEqualTo(3);
		assertThat(menu.getSubmenus().get(0).getSubmenus().get(0).getId()).isEqualTo("first1");
		assertThat(menu.getSubmenus().get(0).getSubmenus().get(1).getId()).isEqualTo("first2");
		assertThat(menu.getSubmenus().get(0).getSubmenus().get(2).getId()).isEqualTo("first3");

		assertThat(menu.getSubmenus().get(0).getSubmenus().get(0).getSubmenus().size()).isEqualTo(2);
		assertThat(menu.getSubmenus().get(0).getSubmenus().get(0).getSubmenus().get(0).getId()).isEqualTo("first1sub1");
		assertThat(menu.getSubmenus().get(0).getSubmenus().get(0).getSubmenus().get(1).getId()).isEqualTo("first1sub2");
	}

}
