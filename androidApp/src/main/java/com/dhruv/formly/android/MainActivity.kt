package com.dhruv.formly.android

import android.content.res.Configuration
import android.graphics.Paint.Align
import android.os.Bundle
import android.view.animation.Animation
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.dhruv.formly.Greeting

class MainActivity : ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Black)

                ){
                    SplashScreen1()
                }
        }
    }
}

enum class Direction{
    UPTODOWN,
    DOWNTOUP
}

@Composable
fun getAnimate(targetValue : Float,time:Int,direction:Direction): Float{
    val infiniteTransition = rememberInfiniteTransition()
    val initial: Float
    val target: Float
    if (direction == Direction.DOWNTOUP){
        initial= 0f
        target =targetValue
    }else{
        initial = targetValue-((targetValue*40)/100)
        target = 0f
    }
    val animationProgress by infiniteTransition.animateFloat(

        initialValue = initial,
        targetValue = target,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = time)
        )
    )
    return animationProgress
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashScreen1() {

    val BOX1 = "BOX1"
    val CIRCLE = "CIRCLE"

    val constraint = ConstraintSet {
        val box1 = createRefFor(BOX1)
        val circle = createRefFor(CIRCLE)


        constrain(circle) {
            bottom.linkTo(box1.bottom)
            centerHorizontallyTo(box1)
        }
    }
    val urbanistFamily = FontFamily(
        Font(R.font.urbanist_light, FontWeight.Light),
        Font(R.font.urbanist_regular, FontWeight.Normal),
        Font(R.font.urbanist_bold, FontWeight.Bold),
        Font(R.font.urbanist_semibold, FontWeight.SemiBold),
        Font(R.font.urbanist_medium, FontWeight.Medium)
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.fillMaxWidth()

        ) {
            ConstraintLayout(
                constraint,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp)
                    .weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .height(174.dp)
                        .width(120.dp)
                        .clip(
                            shape = RoundedCornerShape(
                                bottomEndPercent = 60,
                                bottomStartPercent = 60
                            )
                        )
                        .background(color = Color(0xFFFEBB92))
                        .layoutId(BOX1)
                )
                Box(
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .height(90.dp)
                        .width(90.dp)
                        .clip(shape = androidx.compose.foundation.shape.CircleShape)
                        .background(color = Color.Black)
                        .layoutId(CIRCLE)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .width(308.dp)
                    .clip(shape = RoundedCornerShape(topStartPercent = 50, bottomStartPercent = 50))
                    .background(
                        brush = Brush.linearGradient(
                            listOf(
                                Color(0xFF145277),
                                Color(0XFF83d0cb)
                            )
                        )
                    )
                    .weight(1f)
            ){

            }

        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .height(120.dp)
                .width(340.dp)
                .clip(shape = RoundedCornerShape(bottomEndPercent = 50, topEndPercent = 50))
                .background(Color.White)
        ){
            Row (
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 15.dp)
                    ){
                Spacer(modifier = Modifier.width(40.dp))
                    Box(
                        modifier = Modifier
                            .width(20.dp)
                            .height(getAnimate(80f, 1500, Direction.DOWNTOUP).dp)
                            .background(
                                brush = Brush.verticalGradient(
                                    listOf(
                                        Color(0xFFFEDB96),
                                        Color(0xFFFFEAD2),
                                        Color(0xFFFFA974)
                                    )
                                )
                            )
                    )
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .height(getAnimate(50f, 1200, Direction.UPTODOWN).dp)
                        .width(20.dp)
                        .background(color = Color.Black)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .height(getAnimate(30f, 1000, Direction.DOWNTOUP).dp)
                        .width(20.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color(0xFF18A0FB),
                                    Color(0xFF8A0FB)
                                )
                            )
                        )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .height(getAnimate(75f, 1450, Direction.UPTODOWN).dp)
                        .width(20.dp)
                        .background(color = Color.Black)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .height(getAnimate(30f, 1000, Direction.DOWNTOUP).dp)
                        .width(20.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color(0xFF00c5df),
                                    Color(0xFF00c5df)
                                )
                            )
                        )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .height(getAnimate(20f, 9000, Direction.UPTODOWN).dp)
                        .width(20.dp)
                        .background(color = Color.Black)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .height(getAnimate(50f, 1200, Direction.DOWNTOUP).dp)
                        .width(20.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color(0xFF907CFF),
                                    Color(0xFF392E7A)
                                )
                            )
                        )
                )
                
            }

        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .height(120.dp)
                .width(308.dp)
                .clip(shape = RoundedCornerShape(topStartPercent = 50, bottomStartPercent = 50))
                .background(
                    color = Color(0xFF323232)
                )
                .align(alignment = Alignment.End)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Create Your Forms And Manage Your Work",
            fontFamily = urbanistFamily, fontSize = 50.sp,
            fontWeight = FontWeight.Black, color =Color.White,
            modifier = Modifier.padding(start = 30.dp)
            )


        Row(
           verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 50.dp)
                    .height(10.dp)
                    .width(40.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStartPercent = 50,
                            bottomStartPercent = 50,
                            topEndPercent = 50,
                            bottomEndPercent = 50
                        )
                    )
                    .background(
                        color = Color(0xFFD9D9D9)
                    )
            )
            Box(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .height(10.dp)
                    .width(10.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xFFD9D9D9))
            )
            Box(
                modifier = Modifier
                    .padding(start = 5.dp)
                    .height(10.dp)
                    .width(10.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xFFD9D9D9))
            )
            Row(horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .width(100.dp)
                        .clip(shape = CircleShape)
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color(0xFF7DB4EB),
                                    Color(0xFF86D2F6),
                                    Color(0xFFB1EAF7),
                                    Color(0xFFF9F6B2),
                                    Color(0xFFF6F24C),
                                    Color(0xFFB5EB51)
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ){
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Text(text = "Start", color = Color.Black, fontFamily = urbanistFamily, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                        Icon(
                            Icons.Default.ArrowForward,
                            contentDescription = null // decorative element
                        )
                    }
                }
            }
        }


    }
}

