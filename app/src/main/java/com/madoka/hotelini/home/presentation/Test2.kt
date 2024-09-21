package com.madoka.hotelini.home.presentation






import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun OverlappingCards() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Create references for the cards
        val (card1, card2, card3) = createRefs()

        // Card 1
        Box(
            modifier = Modifier
                .constrainAs(card1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .height(150.dp)
                .background(Color.Red, RoundedCornerShape(16.dp))
        )

        // Card 2 (overlapping card1)
        Box(
            modifier = Modifier
                .constrainAs(card2) {
                    top.linkTo(card1.bottom, margin = (-50).dp) // Negative margin to overlap
                    start.linkTo(card1.start)
                    end.linkTo(card1.end)
                    width = Dimension.fillToConstraints
                }
                .height(150.dp)
                .background(Color.Green, RoundedCornerShape(16.dp))
        )

        // Card 3 (overlapping card2)
        Box(
            modifier = Modifier
                .constrainAs(card3) {
                    top.linkTo(card2.bottom, margin = (-50).dp) // Negative margin to overlap
                    start.linkTo(card2.start)
                    end.linkTo(card2.end)
                    width = Dimension.fillToConstraints
                }
                .height(150.dp)
                .background(Color.Blue, RoundedCornerShape(16.dp))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOverlappingCards() {
    MaterialTheme {
        OverlappingCards()
    }
}
