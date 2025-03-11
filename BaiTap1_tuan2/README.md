THỰC HÀNH 1 | 30 PHÚT

Tạo một màn hình đơn giản để nhập tên và tuổi,
sau đó hiển thị thông tin và kiểm tra người đó là

Người già (>65), Người lớn (6-65) | trẻ em (2-6) | em bé (>2)THỰC HÀNH 1 | 30 PHÚT

Tạo một màn hình đơn giản để nhập tên và tuổi,
sau đó hiển thị thông tin và kiểm tra người đó là

Người già (>65), Người lớn (6-65) | trẻ em (2-6) | em bé (>2)
![image](https://github.com/user-attachments/assets/46df7249-176d-4051-96be-283e0b4f1c61)

**Mô tả cách làm**
Thiết lập giao diện chính (MainActivity)

Gọi setContent { AgeCheckerScreen() } để hiển thị giao diện kiểm tra tuổi.
Xây dựng giao diện AgeCheckerScreen()

Sử dụng Column để căn giữa nội dung trên màn hình.
Hiển thị tiêu đề "THỰC HÀNH 01" với Text().
Tạo khung nhập thông tin bằng Box() với nền màu xám nhạt (Color.LightGray) và bo góc (RoundedCornerShape).
Dùng Row() để đặt nhãn "Họ và tên" và OutlinedTextField để nhập tên.
Tiếp tục tạo hàng thứ hai để nhập "Tuổi", với KeyboardType.Number.
Xử lý khi nhấn nút "Kiểm tra"

Khi nhấn nút Button, kiểm tra giá trị nhập:
Nếu bỏ trống, hiển thị thông báo lỗi.
Nếu tuổi hợp lệ, phân loại nhóm tuổi:
65: Người già

7-65: Người lớn
2-6: Trẻ em
≤2: Em bé
Hiển thị kết quả

Dùng Text() để hiển thị nhóm tuổi, màu chữ đỏ (Color.Red).

**Kết quả đạt được **
![image](https://github.com/user-attachments/assets/df868a2c-8fcf-45b2-92eb-28fa7254ef8c)
![image](https://github.com/user-attachments/assets/3af2f503-f7d3-417d-8ffc-8fdf204065d5)
![image](https://github.com/user-attachments/assets/868f0846-6940-4a27-acf1-3cacec151f03)
![image](https://github.com/user-attachments/assets/aafab4f0-c075-4b7a-9561-eb6ef4684966)
![image](https://github.com/user-attachments/assets/389537e8-df9d-4906-8290-62573320f3fa)




