package com.example.bai1_tuan03

class TextDetailActivity : BaseDetailActivity() {
    override fun getTitleText(): String = "Text Detail"
    override fun getContentText(): String = "This is a Text component. It displays text."
}

class ImageDetailActivity : BaseDetailActivity() {
    override fun getTitleText(): String = "Image Detail"
    override fun getContentText(): String = "This is an Image component. It displays images."
}

class TextFieldDetailActivity : BaseDetailActivity() {
    override fun getTitleText(): String = "TextField Detail"
    override fun getContentText(): String = "This is a TextField component. It allows user input."
}

class PasswordFieldDetailActivity : BaseDetailActivity() {
    override fun getTitleText(): String = "PasswordField Detail"
    override fun getContentText(): String = "This is a PasswordField component. It hides input text."
}

class ColumnDetailActivity : BaseDetailActivity() {
    override fun getTitleText(): String = "Column Detail"
    override fun getContentText(): String = "This is a Column component. It arranges elements vertically."
}

class RowDetailActivity : BaseDetailActivity() {
    override fun getTitleText(): String = "Row Detail"
    override fun getContentText(): String = "This is a Row component. It arranges elements horizontally."
}
