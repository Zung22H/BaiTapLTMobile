Câu 1. Mong muốn và định hướng của Bạn là gì sau khi học xong môn học là gì?
Mong muốn của em qua môn học này là biết được và học được những kĩ năng thực tế mà công ty đòi hỏi ở một lập trình viên thiết bị di động.
Định hướng của em sẽ tiếp tục học hỏi và tìm hiểu thêm các công nghệ mới sau khi đã học môn học này và sau khi đủ kiến thức cần có em sẽ nộp hồ sơ xin thực tập
ở một công ty về lập trình app mobile để tích lũy kinh nghiệm .

Câu 2. Theo bạn, trong tương lai gần (10 năm) lập trình di động có phát triển không? Giải thích tại sao?
Lập trình di động sẽ tiếp tục phát triển mạnh mẽ trong 10 năm tới với những lý do sau:
Sự Bùng Nổ Của Thiết Bị Di Động
- Số lượng smartphone toàn cầu dự kiến sẽ vượt 7.7 tỷ thiết bị vào năm 2028
Nhu cầu sử dụng ứng dụng di động tăng cao ở mọi lĩnh vực như giáo dục, y tế, thương mại điện tử
Công Nghệ Đang Chuyển Mình
- Xuất hiện những công nghệ mới: AI, AR/VR, IoT tích hợp trên mobile
5G và 6G sẽ mở ra những khả năng hoàn toàn mới cho ứng dụng di động
Những framework như Flutter, React Native, Kotlin Multiplatform giúp phát triển ứng dụng dễ dàng hơn
Nhu Cầu Thị Trường
- Các doanh nghiệp đang chuyển dần sang trải nghiệm số
Làn sóng chuyển đổi số đòi hỏi nhiều ứng dụng chuyên nghiệp
Startup và doanh nghiệp đầu tư mạnh vào giải pháp di động
Tiềm Năng Kinh Tế Khổng Lồ
- Thị trường ứng dụng di động toàn cầu dự báo đạt 407 tỷ USD vào năm 2026
Mức lương của lập trình viên di động liên tục tăng
Xu Hướng Công Nghệ Mới
= Ứng dụng AI và machine learning trên mobile
Phát triển ứng dụng cho các thiết bị thông minh
Bảo mật và riêng tư dữ liệu ngày càng được chú trọng.

Câu 3 Viết một ứng dụng có UI như sau đẩy lên github
Ứng dụng có UI sau
Thanh điều hướng (AppBar)
- Nút Back  ở góc trái:
- Nút Chỉnh sửa  ở góc phải:
Ảnh đại diện
Vị trí: Ở trung tâm, hơi đẩy lên phía trên.
Kiểu hiển thị: Hình tròn
Thông tin người dùng
Tên người dùng 
Cỡ chữ lớn , đậm.
Địa chỉ 
Cỡ chữ nhỏ hơn , màu nhạt hơn

Code:
ComponentActivity: Đây là activity chính của ứng dụng, nơi giao diện được khởi chạy.
enableEdgeToEdge(): Cho phép ứng dụng hiển thị tràn viền (ẩn thanh điều hướng).
setContent {}: Định nghĩa giao diện bằng Jetpack Compose.
BaiTap1Theme {}: Sử dụng theme tùy chỉnh để đồng bộ màu sắc và kiểu chữ.
Scaffold():
Là một layout container chuẩn của Material 3.
modifier = Modifier.fillMaxSize(): Cho phép giao diện chiếm toàn bộ màn hình.
innerPadding: Được sử dụng để tránh chồng lên status bar.
@Composable: Định nghĩa một hàm Composable dùng để vẽ giao diện.
Box():
Một container giúp chồng các phần tử lên nhau.
modifier.fillMaxSize(): Làm cho Box chiếm toàn bộ màn hình.
Row():

Dùng để xếp ngang hai nút Back và Edit.
horizontalArrangement = Arrangement.SpaceBetween: Căn nút Back bên trái và nút Edit bên phải.
padding(16.dp): Giữ khoảng cách lề ngoài.
Nút Back (IconButton)

Icons.AutoMirrored.Filled.KeyboardArrowLeft: Đây là phiên bản tự động lật của KeyboardArrowLeft (để phù hợp với ngôn ngữ từ trái sang phải).
contentDescription = "Back": Cung cấp mô tả hỗ trợ truy cập cho người khiếm thị.
Nút Edit (IconButton)

Icons.Default.Edit: Hiển thị biểu tượng chỉnh sửa.
onClick = { }: Hiện tại chưa có sự kiện, có thể thêm hàm điều hướng hoặc mở màn hình chỉnh sửa.
Column():

Sắp xếp các thành phần theo chiều dọc.
horizontalAlignment = Alignment.CenterHorizontally: Căn giữa theo trục ngang.
verticalArrangement = Arrangement.Center: Căn giữa theo trục dọc.
Dịch chuyển lên trên (offset(y = -100.dp)):

Đẩy toàn bộ Column lên 1/3 màn hình.

painterResource(id = R.drawable.profile):
Load ảnh từ thư mục res/drawable.
contentScale = ContentScale.Crop:
Cắt ảnh để vừa với hình tròn.
modifier.size(100.dp).clip(CircleShape):
Đặt kích thước ảnh 100.dp và bo tròn bằng CircleShape.
Spacer(height = 8.dp): Tạo khoảng cách giữa ảnh và tên.
Tên người dùng (Text())
Cỡ chữ lớn (22.sp)
Chữ đậm (FontWeight.Bold)
Địa chỉ (Text())
Cỡ chữ nhỏ hơn (18.sp).
Màu xám nhạt (alpha = 0.6f).
@Preview(showBackground = true):
Hiển thị bản xem trước trong Android Studio.
Dùng ProfileScreen() để hiển thị giao diện trong chế độ Preview.

OUTPUT:

![output1](https://github.com/user-attachments/assets/40ad7633-832d-4948-9ef4-095f8cfe3d32)
