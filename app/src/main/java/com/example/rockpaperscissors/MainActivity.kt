package com.example.rockpaperscissors

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.*
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import kotlin.random.Random
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rockButton = findViewById<ImageButton>(R.id.rockButton)
        val paperButton = findViewById<ImageButton>(R.id.paperButton)
        val scissorsButton = findViewById<ImageButton>(R.id.scissorsButton)
        val playerScore = findViewById<TextView>(R.id.playerScore)
        val jarvisScore = findViewById<TextView>(R.id.jarvisScore)
        val rockMiniLeft = findViewById<ImageView>(R.id.rockMiniLeft)
        val rockMiniRight = findViewById<ImageView>(R.id.rockMiniRight)
        val paperMiniLeft = findViewById<ImageView>(R.id.paperMiniLeft)
        val paperMiniRight = findViewById<ImageView>(R.id.paperMiniRight)
        val scissorsMiniLeft = findViewById<ImageView>(R.id.scissorsMiniLeft)
        val scissorsMiniRight = findViewById<ImageView>(R.id.scissorsMiniRight)
        val magic = findViewById<ImageView>(R.id.magic)
        val hiddenButton = findViewById<Button>(R.id.hiddenButton)
        val gameScreen = findViewById<ImageView>(R.id.gameScreen)
        var iconTopR = findViewById<ImageView>(R.id.right_top_icon)
        var iconTopL = findViewById<ImageView>(R.id.left_top_icon)
        var iconMidR = findViewById<ImageView>(R.id.right_mid_icon)
        var iconMidL = findViewById<ImageView>(R.id.left_mid_icon)
        var iconBotR = findViewById<ImageView>(R.id.right_bottom_icon)
        var iconBotL = findViewById<ImageView>(R.id.left_bottom_icon)
        val gameScreenViz = arrayListOf(
            gameScreen, iconTopR, iconTopL, iconMidR,
            iconMidL, iconBotR, iconBotL
        )
        val winnerTxt = findViewById<TextView>(R.id.winnerTxt)
        val winnerName = findViewById<TextView>(R.id.winnerName)
        val winnerVs = findViewById<TextView>(R.id.vsText2)
        // Calling View items into kotlin

        magic.visibility = INVISIBLE
        rockMiniLeft.visibility = INVISIBLE
        rockMiniRight.visibility = INVISIBLE
        paperMiniLeft.visibility = INVISIBLE
        paperMiniRight.visibility = INVISIBLE
        scissorsMiniLeft.visibility = INVISIBLE
        scissorsMiniRight.visibility = INVISIBLE
        gameScreen.visibility = INVISIBLE
        iconTopR.visibility = INVISIBLE
        iconTopL.visibility = INVISIBLE
        iconMidR.visibility = INVISIBLE
        iconMidL.visibility = INVISIBLE
        iconBotR.visibility = INVISIBLE
        iconBotL.visibility = INVISIBLE
        winnerName.visibility = INVISIBLE
        winnerTxt.visibility = INVISIBLE
        winnerVs.visibility = INVISIBLE

        // Controls for the end screen Icons
        var iconL = 0
        var iconR = 0

        // Values for if statement
        var scoreAddPlayer = 0 // Used to do math and update player score
        var scoreAddJarvis = 0 // USed to do math and update Jarvis score

        playerScore.text = scoreAddPlayer.toString()
        jarvisScore.text = scoreAddJarvis.toString()

        hiddenButton.setOnClickListener {

            iconL = 0
            iconR = 0
            val jarvisR = 0
            scoreAddJarvis = 0
            jarvisScore.text = scoreAddJarvis.toString()
            scoreAddPlayer = 0
            playerScore.text = scoreAddPlayer.toString()
            magic.visibility = INVISIBLE
            rockMiniLeft.visibility = INVISIBLE
            rockMiniRight.visibility = INVISIBLE
            paperMiniLeft.visibility = INVISIBLE
            paperMiniRight.visibility = INVISIBLE
            scissorsMiniLeft.visibility = INVISIBLE
            scissorsMiniRight.visibility = INVISIBLE
            gameScreen.visibility = INVISIBLE
            rockButton.visibility = VISIBLE
            paperButton.visibility = VISIBLE
            scissorsButton.visibility = VISIBLE
            iconTopR.visibility = INVISIBLE
            iconTopL.visibility = INVISIBLE
            iconMidR.visibility = INVISIBLE
            iconMidL.visibility = INVISIBLE
            iconBotR.visibility = INVISIBLE
            iconBotL.visibility = INVISIBLE
            winnerName.visibility = INVISIBLE
            winnerTxt.visibility = INVISIBLE
            winnerVs.visibility = INVISIBLE
            winnerName.visibility = INVISIBLE
        }

        rockButton.setOnClickListener {
            iconTopR.isEnabled = false

            val jarvisR = Random.nextInt(1..3)
            rockMiniLeft.visibility = VISIBLE
            rockMiniRight.visibility = INVISIBLE
            paperMiniLeft.visibility = INVISIBLE
            paperMiniRight.visibility = INVISIBLE
            scissorsMiniLeft.visibility = INVISIBLE
            scissorsMiniRight.visibility = INVISIBLE

            if (jarvisR != 1 && iconL == 0) {
                iconTopL.isPressed = true
                iconL = 1
            } else if (jarvisR != 1 && iconL == 1) {
                iconMidL.isPressed = true
                iconL = 3
            } else if (jarvisR != 1 && iconL == 3) {
                iconBotL.isPressed = true
                iconL = 10
            }

            if (jarvisR != 1 && iconR == 0) {
                when (jarvisR) {
                    1 -> {
                        iconTopR.isPressed = true
                        iconR = 1
                    }
                    2 -> {
                        iconTopR.isEnabled = true
                        iconR = 1
                    }
                    3 -> {
                        iconTopR.isEnabled = false
                        iconR = 1
                    }
                }
            } else if (jarvisR != 1 && iconR == 1) {
                when (jarvisR) {
                    1 -> {
                        iconMidR.isPressed = true
                        iconR = 3
                    }
                    2 -> {
                        iconMidR.isEnabled = true
                        iconR = 3
                    }
                    3 -> {
                        iconMidR.isEnabled = false
                        iconR = 3
                    }
                }
            } else if (jarvisR != 1 && iconR == 3) {
                when (jarvisR) {
                    1 -> {
                        iconBotR.isPressed = true
                        iconR = 10
                    }
                    2 -> {
                        iconBotR.isEnabled = true
                        iconR = 10
                    }
                    3 -> {
                        iconBotR.isEnabled = false
                        iconR = 10
                    }
                }
            }


            when (jarvisR) {
                2 -> {
                    paperMiniRight.visibility = VISIBLE
                    scoreAddJarvis += 1
                    jarvisScore.text = scoreAddJarvis.toString()
                }
                3 -> {
                    scissorsMiniRight.visibility = VISIBLE
                    scoreAddPlayer += 1
                    playerScore.text = scoreAddPlayer.toString()

                }
                else -> {
                    rockMiniRight.visibility = VISIBLE
                }
            }
            if (scoreAddJarvis == 2 && scoreAddPlayer == 1 || scoreAddJarvis == 3){
                    winnerName.text = "Jarvis"
                    winnerName.visibility = VISIBLE
                    rockButton.visibility = INVISIBLE
                    paperButton.visibility = INVISIBLE
                    scissorsButton.visibility = INVISIBLE
                    gameScreen.visibility = VISIBLE
                    iconTopR.visibility = VISIBLE
                    iconTopL.visibility = VISIBLE
                    iconMidR.visibility = VISIBLE
                    iconMidL.visibility = VISIBLE
                    iconBotR.visibility = VISIBLE
                    iconBotL.visibility = VISIBLE
                    winnerName.visibility = VISIBLE
                    winnerTxt.visibility = VISIBLE
                    winnerVs.visibility = VISIBLE

                }

            if (scoreAddPlayer == 2 && scoreAddJarvis == 1 || scoreAddPlayer == 3) {
                    winnerName.text = "Player"
                    winnerName.visibility = VISIBLE
                    rockButton.visibility = INVISIBLE
                    paperButton.visibility = INVISIBLE
                    scissorsButton.visibility = INVISIBLE
                    gameScreen.visibility = VISIBLE
                    iconTopR.visibility = VISIBLE
                    iconTopL.visibility = VISIBLE
                    iconMidR.visibility = VISIBLE
                    iconMidL.visibility = VISIBLE
                    iconBotR.visibility = VISIBLE
                    iconBotL.visibility = VISIBLE
                    winnerName.visibility = VISIBLE
                    winnerTxt.visibility = VISIBLE
                    winnerVs.visibility = VISIBLE

                    }
                }


            paperButton.setOnClickListener {
                iconTopR.isEnabled = false
                val jarvisR = Random.nextInt(1..3)
                rockMiniLeft.visibility = INVISIBLE
                rockMiniRight.visibility = INVISIBLE
                paperMiniLeft.visibility = VISIBLE
                paperMiniRight.visibility = INVISIBLE
                scissorsMiniLeft.visibility = INVISIBLE
                scissorsMiniRight.visibility = INVISIBLE

                if (jarvisR != 2 && iconL == 0) {
                    iconTopL.isEnabled = true
                    iconL = 1
                } else if (jarvisR != 2 && iconL == 1) {
                    iconMidL.isEnabled = true
                    iconL = 3
                } else if (jarvisR != 2 && iconL == 3) {
                    iconBotL.isEnabled = true
                    iconL = 10
                }

                if (jarvisR != 2 && iconR == 0) {
                    when (jarvisR) {
                        1 -> {
                            iconTopR.isPressed = true
                            iconR = 1
                        }
                        2 -> {
                            iconTopR.isEnabled = true
                            iconR = 1
                        }
                        3 -> {
                            iconTopR.isEnabled = false
                            iconR = 1
                        }
                    }
                } else if (jarvisR != 2 && iconR == 1) {
                    when (jarvisR) {
                        1 -> {
                            iconMidR.isPressed = true
                            iconR = 3
                        }
                        2 -> {
                            iconMidR.isEnabled = true
                            iconR = 3
                        }
                        3 -> {
                            iconMidR.isEnabled = false
                            iconR = 3
                        }
                    }
                } else if (jarvisR != 2 && iconR == 3) {
                    when (jarvisR) {
                        1 -> {
                            iconBotR.isPressed = true
                            iconR = 10
                        }
                        2 -> {
                            iconBotR.isEnabled = true
                            iconR = 10
                        }
                        3 -> {
                            iconBotR.isEnabled = false
                            iconR = 10
                        }
                    }
                }

                when (jarvisR) {
                    1 -> {
                        rockMiniRight.visibility = VISIBLE
                        scoreAddPlayer += 1
                        playerScore.text = scoreAddPlayer.toString()
                    }
                    3 -> {
                        scissorsMiniRight.visibility = VISIBLE
                        scoreAddJarvis += 1
                        jarvisScore.text = scoreAddJarvis.toString()

                    }
                    else -> {
                        paperMiniRight.visibility = VISIBLE
                    }
                }
                if (scoreAddJarvis == 2 && scoreAddPlayer == 1 || scoreAddJarvis == 3){
                    winnerName.text = "Jarvis"
                    winnerName.visibility = VISIBLE
                    rockButton.visibility = INVISIBLE
                    paperButton.visibility = INVISIBLE
                    scissorsButton.visibility = INVISIBLE
                    gameScreen.visibility = VISIBLE
                    iconTopR.visibility = VISIBLE
                    iconTopL.visibility = VISIBLE
                    iconMidR.visibility = VISIBLE
                    iconMidL.visibility = VISIBLE
                    iconBotR.visibility = VISIBLE
                    iconBotL.visibility = VISIBLE
                    winnerName.visibility = VISIBLE
                    winnerTxt.visibility = VISIBLE
                    winnerVs.visibility = VISIBLE

                }

                if (scoreAddPlayer == 2 && scoreAddJarvis == 1 || scoreAddPlayer == 3) {
                    winnerName.text = "Player"
                    winnerName.visibility = VISIBLE
                    rockButton.visibility = INVISIBLE
                    paperButton.visibility = INVISIBLE
                    scissorsButton.visibility = INVISIBLE
                    gameScreen.visibility = VISIBLE
                    iconTopR.visibility = VISIBLE
                    iconTopL.visibility = VISIBLE
                    iconMidR.visibility = VISIBLE
                    iconMidL.visibility = VISIBLE
                    iconBotR.visibility = VISIBLE
                    iconBotL.visibility = VISIBLE
                    winnerName.visibility = VISIBLE
                    winnerTxt.visibility = VISIBLE
                    winnerVs.visibility = VISIBLE

                }
            }

            scissorsButton.setOnClickListener {
                println(iconTopR)
                val jarvisR = Random.nextInt(1..3)
                rockMiniLeft.visibility = INVISIBLE
                rockMiniRight.visibility = INVISIBLE
                paperMiniLeft.visibility = INVISIBLE
                paperMiniRight.visibility = INVISIBLE
                scissorsMiniLeft.visibility = VISIBLE
                scissorsMiniRight.visibility = INVISIBLE

                if (jarvisR != 3 && iconL == 0) {
                    iconTopL.isEnabled = false
                    iconL = 1
                } else if (jarvisR != 3 && iconL == 1) {
                    iconMidL.isEnabled = false
                    iconL = 3
                } else if (jarvisR != 3 && iconL == 3) {
                    iconBotL.isEnabled = false
                    iconL = 10
                }

                if (jarvisR != 3 && iconR == 0) {
                    when (jarvisR) {
                        1 -> {
                            iconTopR.isPressed = true
                            iconR = 1
                        }
                        2 -> {
                            iconTopR.isEnabled = true
                            iconR = 1
                        }
                        3 -> {
                            iconTopR.isEnabled = false
                            iconR = 1
                        }
                    }
                } else if (jarvisR != 3 && iconR == 1) {
                    when (jarvisR) {
                        1 -> {
                            iconMidR.isPressed = true
                            iconR = 3
                        }
                        2 -> {
                            iconMidR.isEnabled = true
                            iconR = 3
                        }
                        3 -> {
                            iconMidR.isEnabled = false
                            iconR = 3
                        }
                    }
                } else if (jarvisR != 3 && iconR == 3) {
                    when (jarvisR) {
                        1 -> {
                            iconBotR.isPressed = true
                            iconR = 10
                        }
                        2 -> {
                            iconBotR.isEnabled = true
                            iconR = 10
                        }
                        3 -> {
                            iconBotR.isEnabled = false
                            iconR = 10
                        }
                    }
                }



                when (jarvisR) {
                    1 -> {
                        rockMiniRight.visibility = VISIBLE
                        scoreAddJarvis += 1
                        jarvisScore.text = scoreAddJarvis.toString()
                    }
                    2 -> {
                        paperMiniRight.visibility = VISIBLE
                        scoreAddPlayer += 1
                        playerScore.text = scoreAddPlayer.toString()

                    }
                    else -> {
                        scissorsMiniRight.visibility = VISIBLE
                    }
                }
                if (scoreAddJarvis == 2 && scoreAddPlayer == 1 || scoreAddJarvis == 3){
                    winnerName.text = "Jarvis"
                    winnerName.visibility = VISIBLE
                    rockButton.visibility = INVISIBLE
                    paperButton.visibility = INVISIBLE
                    scissorsButton.visibility = INVISIBLE
                    gameScreen.visibility = VISIBLE
                    iconTopR.visibility = VISIBLE
                    iconTopL.visibility = VISIBLE
                    iconMidR.visibility = VISIBLE
                    iconMidL.visibility = VISIBLE
                    iconBotR.visibility = VISIBLE
                    iconBotL.visibility = VISIBLE
                    winnerName.visibility = VISIBLE
                    winnerTxt.visibility = VISIBLE
                    winnerVs.visibility = VISIBLE

                }

                if (scoreAddPlayer == 2 && scoreAddJarvis == 1 || scoreAddPlayer == 3) {
                    winnerName.text = "Player"
                    winnerName.visibility = VISIBLE
                    rockButton.visibility = INVISIBLE
                    paperButton.visibility = INVISIBLE
                    scissorsButton.visibility = INVISIBLE
                    gameScreen.visibility = VISIBLE
                    iconTopR.visibility = VISIBLE
                    iconTopL.visibility = VISIBLE
                    iconMidR.visibility = VISIBLE
                    iconMidL.visibility = VISIBLE
                    iconBotR.visibility = VISIBLE
                    iconBotL.visibility = VISIBLE
                    winnerName.visibility = VISIBLE
                    winnerTxt.visibility = VISIBLE
                    winnerVs.visibility = VISIBLE

                }
            }
        }
    }
