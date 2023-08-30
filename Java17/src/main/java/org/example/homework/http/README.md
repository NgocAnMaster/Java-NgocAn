Đọc documentation của Posts trong link: https://dummyjson.com/docs/posts

Viết các method sau để tạo HTTP request tương ứng tới dummyjson.com:

1. List<Post> list(int page, int size): Danh sách <size> bài viết ở trang thứ <page>. Với page >= 1
   Ví dụ:
   page = 1, size = 10: Danh sách các bài viết 1 - 10
   page = 2, size = 10: Danh sách các bài viết 11 - 20
   ...

2. Post create(Post post): Tạo bài viết mới, trả ra bài viết đã được tạo
3. Post update(int id, Post post): Cập nhật bài viết, trả ra bài viết vừa được cập nhật
4. Post delete(int id): Xoá bài viết và trả ra bài viết vừa bị xoá