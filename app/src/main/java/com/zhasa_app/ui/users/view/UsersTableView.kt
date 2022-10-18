package com.zhasa_app.ui.users.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.zhasa_app.ui.common.NormalText
import com.zhasa_app.ui.common.SmallText
import com.zhasa_app.ui.common.TitleWithSubtitleView
import com.zhasa_app.ui.theme.Size
import com.zhasa_app.ui.users.models.UserModel
import com.zhasa_app.ui.users.models.UsersList

@Composable
fun UserItemView(position: Int, userTableModel: UserModel) {
    Box(modifier = Modifier.height(Size.SPACE_6)) {
        NormalText(
            text = position.toString(),
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(Size.SPACE_1)
        )
        TitleWithSubtitleView(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = Size.SPACE_8),
            userTableModel.fullName,
            "КВЦ ${userTableModel.kvcPercentage.toPresentation()}"
        )
        SmallText(
            text = userTableModel.branchName, textColor = Color.Gray, modifier = Modifier
                .align(
                    Alignment.CenterEnd
                )
                .padding(end = Size.SPACE_1)
        )
        Spacer(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(Size.SPACE_MINIMUM)
                .background(Color.White)
        )
    }
}

@Composable
fun UserListView(usersList: UsersList) {
    LazyColumn {
        itemsIndexed(usersList) { index, item ->
            UserItemView(position = index + 1, userTableModel = item)
        }
    }
}