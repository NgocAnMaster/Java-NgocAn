Cho các entity:

- User: id, firstName, lastName, dob
- Post: id, userId, publishedAt, content
- Reaction: id, postId, userId, type {LIKE, DISLIKE, CRY, LOVE}

Yêu cầu:

1. Tạo table trong database PostgreSQL users_<yourname>, posts_<yourname>, reactions_<yourname> và thêm các bản ghi ngẫu
   nhiên. Sử dụng snake case cho tên bảng và cột
2. Tạo các method sau trong Java:
   a. List<User> listUsers(): Danh sách tất cả user
   b. List<Post> listPosts(int userId): Danh sách tất cả bài đăng của 1 user
   c. List<Reaction> listReactions(int postId, Type type): Danh sách tất cả lượt tương tác của 1 bài đăng với loại là
   type được truyền vào. Nếu type là null thì trả ra tất cả lượt tương tác của bài đăng đó
   d. List<User> listReactedUsers(int userId): Danh sách các user đã tương tác với user được truyền vào (tức là đã tương
   tác với bài đăng của user đó)