/**
 * @author Blake Dykstra - bdykstra
 * CIS175 - Spring 2024
 * Feb 4, 2024
 */

import java.util.List;
import java.util.Scanner;

import controller.VideoGameHelper;
import model.VideoGame;

/**
 * 
 */
public class RunProgram {
	static Scanner in = new Scanner(System.in);
	static VideoGameHelper vgh = new VideoGameHelper();
	
	public static void main(String[] Args) {
		run();
	}
	
	public static void run() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome list of video games! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an item");
			System.out.println("*  2 -- Edit an item");
			System.out.println("*  3 -- Delete an item");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				vgh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}
	}
		
	private static void addAnItem() {
		System.out.print("Enter a game: ");
		String name = in.nextLine();
		System.out.print("Enter the developer: ");
		String developer = in.nextLine();
		System.out.print("Enter the publisher: ");
		String publisher = in.nextLine();
		VideoGame toAdd = new VideoGame(name, developer, publisher);
		vgh.insertItem(toAdd);
	}
	
	private static void deleteAnItem() {
		System.out.print("Enter the game to delete: ");
		String name = in.nextLine();
		System.out.print("Enter the developer: ");
		String developer = in.nextLine();
		System.out.print("Enter the publisher: ");
		String publisher = in.nextLine();
		VideoGame toDelete = new VideoGame(name, developer, publisher);
		vgh.deleteItem(toDelete);
	}
	
	private static void viewTheList() {
		List<VideoGame> allItems = vgh.showAllItems();
		for(VideoGame singleItem : allItems) {
			System.out.println(singleItem.returnGameDetails());
		}
	}
	
	private static void editAnItem() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Name");
		System.out.println("2 : Search by Developer");
		System.out.println("3 : Search by Publisher");
		int searchBy = in.nextInt();
		in.nextLine();
		List<VideoGame> foundGames;
		if(searchBy == 1) {
			System.out.print("Enter the game's name: ");
			String gameName = in.nextLine();
			foundGames = vgh.searchForGameByName(gameName);
		} else if(searchBy == 2) {
			System.out.print("Enter the game's developer: ");
			String gameDeveloper = in.nextLine();
			foundGames = vgh.searchForGameByDeveloper(gameDeveloper);
		} else {
			System.out.print("Enter the game's publisher: ");
			String gamePublisher = in.nextLine();
			foundGames = vgh.searchForGameByPublisher(gamePublisher);
		}
		
		if (!foundGames.isEmpty()) {
			System.out.println("Found Results.");
			for (VideoGame v : foundGames) {
				System.out.println(v.getId() + " : " + v.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();
			
			VideoGame toEdit = vgh.searchForGameById(idToEdit);
			System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getDeveloper() + " and " + toEdit.getPublisher());
			System.out.println("1 : Update Name");
			System.out.println("2 : Update Developer");
			System.out.println("3 : Update Publisher");
			int update = in.nextInt();
			in.nextLine();
			
			if (update == 1) {
				System.out.print("New Name: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
			} else if (update == 2) {
				System.out.print("New Developer: ");
				String newDeveloper = in.nextLine();
				toEdit.setDeveloper(newDeveloper);
			} else if (update == 3) {
				System.out.print("New Publisher: ");
				String newPublisher = in.nextLine();
				toEdit.setPublisher(newPublisher);
			}
			
			vgh.updateItem(toEdit);
			
		} else {
			System.out.println("---- No results found");
		}
	}
	
}
