package org.example.homework.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public Main() throws IOException {
    }

    public static PostResponse postResponse() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://dummyjson.com/posts")
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String string = response.body().string();
//        System.out.println(string);

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(string, PostResponse.class);
    }

    public static List<Post> listPosts() throws IOException {
        PostResponse post = postResponse();
        return new ArrayList<>(post.getPosts());
    }

    private static final List<Post> posts;

    static {
        try {
            posts = new ArrayList<>(listPosts());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printException(Exception e) {
        System.err.println("An exception occurred while processing the request:");
        e.printStackTrace();
        System.err.println("Please try your request again. If the exception persists, contact the software developer.");
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the Posts Wizard!");
        Scanner sc = new Scanner(System.in);
        boolean status = true;
        do {
            try {
                System.out.println("What do you want to do?");
                System.out.println("Select:");
                System.out.println("1 to generate the list of posts in your given posts");
                System.out.println("2 to create your new post");
                System.out.println("3 to update a post");
                System.out.println("4 to delete a post");
                System.out.println("5 to exit. WARNING: All your progresses will be lost!");
                int option;
                do {
                    System.out.print("Select an option: ");
                    option = sc.nextInt();
                } while (option < 1 || option > 5);
                System.out.println("Option selected: " + option);
                switch (option) {
                    case 1: {
                        System.out.println("---------------------------------------------------------------------------------------------------");
                        System.out.println("GENERATE LIST OF POSTS");
                        System.out.print("Enter the limit of posts you want to watch (0 for all posts): ");
                        int size = sc.nextInt();
                        System.out.print("Which page do you want to watch? -> ");
                        int page = sc.nextInt();
                        List<Post> posts1 = new ArrayList<>(list(page, size));
                        if (posts1.size() == 0) {
                            System.out.println("Sorry, no posts in your specified range for you to watch.");
                        } else {
                            System.out.println("Here's the list of posts for you to watch: ");
                            for (int i = 0; i < posts1.size(); i++) {
                                System.out.println((i + 1) + ". Post #" + posts1.get(i).getId() + ": \"" + posts1.get(i).getTitle() + "\", main content: " + posts1.get(i).getBody());
                            }
                        }
                        System.out.println("---------------------------------------------------------------------------------------------------");
                        break;
                    }
                    case 2: {
                        System.out.println("---------------------------------------------------------------------------------------------------");
                        System.out.println("CREATE A NEW POST");
                        Post post = new Post();
                        System.out.println("A new post is a warm welcome to us. But first, we need some information to create a new post for you. Then it will be saved into our database.");
                        System.out.print("Enter your desired ID: ");
                        int id = sc.nextInt();
                        boolean checkId = true;
                        for (Post value : posts) {
                            if (value.getId() == id) {
                                System.out.println("That ID already have a post. Try another one.");
                                System.out.println("---------------------------------------------------------------------------------------------------");
                                checkId = false;
                                break;
                            }
                        }
                        if (!checkId) break;
                        System.out.print("Type in your desired title: ");
                        sc.nextLine();
                        String title = sc.nextLine();
                        System.out.println("Now, let's enter your content, and press Enter when done:");
                        String body = sc.nextLine();
                        post.setId(id);
                        post.setTitle(title);
                        post.setBody(body);
                        create(post);
                        System.out.println("Post created. Here's your post:");
                        System.out.println("Post #" + post.getId() + ": \"" + post.getTitle() + "\", main content: " + post.getBody());
                        System.out.println("---------------------------------------------------------------------------------------------------");
                        break;
                    }
                    case 3: {
                        System.out.println("---------------------------------------------------------------------------------------------------");
                        System.out.println("UPDATE A POST");
                        System.out.println("Want to update a post? Follow the guides below and the updated post will be in our database.");
                        Post post = new Post();
                        System.out.print("Enter the ID of the post you want to update: ");
                        int id = sc.nextInt();
                        boolean checkId = false;
                        for (Post value : posts) {
                            if (value.getId() == id) {
                                checkId = true;
                                break;
                            }
                        }
                        if (!checkId) {
                            System.out.println("The post ID you entered doesn't exist. Try creating it instead.");
                            System.out.println("---------------------------------------------------------------------------------------------------");
                            break;
                        }
                        System.out.print("Enter your new title for the post: ");
                        sc.nextLine();
                        String title = sc.nextLine();
                        System.out.println("Now, let's enter your content, and press Enter when done:");
                        String body = sc.nextLine();
                        post.setId(id);
                        post.setTitle(title);
                        post.setBody(body);
                        Post update = update(id, post);
                        System.out.println("Post updated. Here's your post:");
                        System.out.println("Post #" + update.getId() + ": \"" + update.getTitle() + "\", main content: " + update.getBody());
                        System.out.println("---------------------------------------------------------------------------------------------------");
                        break;
                    }
                    case 4: {
                        System.out.println("---------------------------------------------------------------------------------------------------");
                        System.out.println("DELETE A POST");
                        System.out.println("Is there's any posts that doesn't match you? We can delete it with just a few easy steps.");
                        System.out.print("Enter a post ID: ");
                        int id = sc.nextInt();
                        Post delete = delete(id);
                        if (delete == null) {
                            System.out.println("The post ID you entered doesn't exist. It probably have been deleted before.");
                        } else {
                            System.out.println("Post deleted. Here's your deleted post:");
                            System.out.println("Post #" + delete.getId() + ": \"" + delete.getTitle() + "\", main content: " + delete.getBody());
                        }
                        System.out.println("---------------------------------------------------------------------------------------------------");
                        break;
                    }
                    default: {
                        System.out.print("Are you sure? Your progresses will be lost! (press Y to exit, or any to cancel): ");
                        String c = sc.next();
                        if (c.equals("Y") || c.equals("y")) {
                            System.out.println("Exiting...");
                            status = false;
                        }
                        break;
                    }
                }
            } catch (Exception e) {
                printException(e);
                System.out.println("---------------------------------------------------------------------------------------------------");
                sc.nextLine();
            }
        } while (status);
    }

    public static List<Post> list(int page, int size) throws IOException {
        List<Post> postList = new ArrayList<>();
        if (size == 0) {
            return posts;
        } else
            for (int i = (page - 1) * size; i < ((page - 1) * size + size); i++) {
                if (i >= posts.size())
                    break;
                else postList.add(posts.get(i));
            }
        return postList;
    }

    public static Post create(Post post) {
        posts.add(post);
        return post;
    }

    public static Post update(int id, Post post) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId() == id) {
                posts.set(i, post);
                return post;
            }
        }
        return null;
    }

    public static Post delete(int id) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId() == id) {
                return posts.remove(i);
            }
        }
        return null;
    }
}
