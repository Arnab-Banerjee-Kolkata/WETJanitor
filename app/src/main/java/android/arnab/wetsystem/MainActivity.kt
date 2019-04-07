package android.arnab.wetsystem

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var overHeadTank: ImageView
    lateinit var toilet: ImageView
    lateinit var flush: ImageButton
    lateinit var mp: MediaPlayer
    lateinit var yellow1: ImageView
    lateinit var leftValve: ImageButton
    lateinit var rightValve: ImageButton
    lateinit var yellow2: ImageView
    lateinit var yellow3: ImageView
    lateinit var yellow4: ImageView
    lateinit var ugTank1: ImageView
    lateinit var ugTank2: ImageView
    lateinit var blue1: ImageView
    lateinit var freshValve1: ImageButton
    lateinit var blue2: ImageView
    lateinit var freshValve2: ImageButton
    lateinit var olm: ImageView
    lateinit var blue3: ImageView
    lateinit var blue4: ImageView
    lateinit var green1: ImageView
    lateinit var red1: ImageView
    lateinit var pitPark: ImageView
    lateinit var pump: ImageButton
    lateinit var blue5: ImageView
    lateinit var blue6: ImageView
    lateinit var external: ImageButton
    lateinit var time: TextView
    lateinit var indicator1: ImageView
    lateinit var indicator2: ImageView
    lateinit var indicator3: ImageView
    lateinit var indicator4: ImageView
    lateinit var noBtn: ImageButton
    lateinit var indicator5: ImageView
    lateinit var upperQuan: TextView
    lateinit var ugQuanL1: TextView
    lateinit var ugQuanR1: TextView
    lateinit var trans: ImageView
    lateinit var lv1: ImageButton
    lateinit var lv2: ImageButton
    lateinit var rv1: ImageButton
    lateinit var rv2: ImageButton
    lateinit var indicator6: ImageView
    lateinit var msg: TextView
    lateinit var credBtn: ImageButton
    lateinit var insBtn: ImageButton
    var currentTimeL: Long = 0
    var startTimeL: Long = 0
    var currentTimeR: Long = 0
    var startTimeR: Long = 0
    var currentTimeL2: Long = 0
    var startTimeL2: Long = 0
    var currentTimeR2: Long = 0
    var startTimeR2: Long = 0
    var isLeftValveOpen: Boolean = true
    var isRightValveOpen: Boolean = false
    var isFresh1Open: Boolean = false
    var isFresh2Open: Boolean = false
    var isDraining: Boolean = false
    var ovr = 40
    var ul1 = 1960
    var ul2 = 0
    var ul3 = 0
    var ur1 = 0
    var ur2 = 0
    var ur3 = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        overHeadTank = findViewById(R.id.overHeadTank)
        toilet = findViewById(R.id.toilet)
        flush = findViewById(R.id.flush)
        yellow1 = findViewById(R.id.yellow1)
        leftValve = findViewById(R.id.leftValve)
        rightValve = findViewById(R.id.rightValve)
        yellow2 = findViewById(R.id.yellow2)
        yellow3 = findViewById(R.id.yellow3)
        yellow4 = findViewById(R.id.yellow4)
        ugTank1 = findViewById(R.id.ugTank1)
        ugTank2 = findViewById(R.id.ugTank2)
        blue1 = findViewById(R.id.blue1)
        freshValve1 = findViewById(R.id.freshValve1)
        blue2 = findViewById(R.id.blue2)
        freshValve2 = findViewById(R.id.freshValve2)
        olm = findViewById(R.id.olm)
        blue3 = findViewById(R.id.blue3)
        blue4 = findViewById(R.id.blue4)
        green1 = findViewById(R.id.green1)
        red1 = findViewById(R.id.red1)
        pitPark = findViewById(R.id.pitPark)
        pump = findViewById(R.id.pump)
        blue5 = findViewById(R.id.blue5)
        blue6 = findViewById(R.id.blue6)
        external = findViewById(R.id.external)
        time = findViewById(R.id.time)
        indicator1 = findViewById(R.id.indictor1)
        indicator2 = findViewById(R.id.indicator2)
        indicator3 = findViewById(R.id.indicator3)
        indicator4 = findViewById(R.id.indicator4)
        noBtn = findViewById(R.id.noBtn)
        indicator5 = findViewById(R.id.indicator5)
        upperQuan = findViewById(R.id.upperQuan)
        ugQuanL1 = findViewById(R.id.ugQuanL1)
        ugQuanR1 = findViewById(R.id.ugQuanR1)
        trans = findViewById(R.id.trans)
        lv1 = findViewById(R.id.lv1)
        lv2 = findViewById(R.id.lv2)
        rv1 = findViewById(R.id.rv1)
        rv2 = findViewById(R.id.rv2)
        indicator6 = findViewById(R.id.indicator6)
        msg = findViewById(R.id.msg)
        credBtn=findViewById(R.id.credBtn)
        insBtn=findViewById(R.id.insBtn)

        mp = MediaPlayer.create(this, R.raw.flush_sound)

        Glide.with(this).load(R.drawable.tankcopy).into(overHeadTank)
        Glide.with(this).load(R.drawable.toiletcopy).into(toilet)
        Glide.with(this).load(R.drawable.flushcopy).into(flush)
        Glide.with(this).load(R.drawable.arrow_grey_down).into(yellow1)
        Glide.with(this).load(R.drawable.valvecopy).into(leftValve)
        Glide.with(this).load(R.drawable.valvecopy).into(rightValve)
        Glide.with(this).load(R.drawable.arrow_grey_left).into(yellow2)
        Glide.with(this).load(R.drawable.arrow_grey_right).into(yellow3)
        Glide.with(this).load(R.drawable.arrow_grey_down).into(yellow4)
        Glide.with(this).load(R.drawable.ug_tank).into(ugTank1)
        Glide.with(this).load(R.drawable.ug_tank).into(ugTank2)
        Glide.with(this).load(R.drawable.arrow_blue_right).into(blue1)
        Glide.with(this).load(R.drawable.valvecopy).into(freshValve1)
        Glide.with(this).load(R.drawable.arrow_blue_right).into(blue2)
        Glide.with(this).load(R.drawable.valvecopy).into(freshValve2)
        Glide.with(this).load(R.drawable.olm).into(olm)
        Glide.with(this).load(R.drawable.arrow_grey_right).into(blue3)
        Glide.with(this).load(R.drawable.arrow_grey_right).into(blue4)
        Glide.with(this).load(R.drawable.arrow_grey_up).into(green1)
        Glide.with(this).load(R.drawable.arrow_grey_right).into(red1)
        Glide.with(this).load(R.drawable.pitparkcopy).into(pitPark)
        Glide.with(this).load(R.drawable.pump).into(pump)
        Glide.with(this).load(R.drawable.arrow_grey_up).into(blue5)
        Glide.with(this).load(R.drawable.arrow_grey_left).into(blue6)
        Glide.with(this).load(R.drawable.extsupcopy).into(external)
        Glide.with(this).load(R.drawable.red_ring).into(indicator1)
        Glide.with(this).load(R.drawable.green_ring).into(indicator2)
        Glide.with(this).load(R.drawable.red_ring).into(indicator3)
        Glide.with(this).load(R.drawable.red_ring).into(indicator4)
        Glide.with(this).load(R.drawable.drain).into(noBtn)
        Glide.with(this).load(R.drawable.red_ring).into(indicator5)
        Glide.with(this).load(R.drawable.trans_grey).into(trans)
        Glide.with(this).load(R.drawable.green_ring).into(indicator6)
        Glide.with(this).load(R.drawable.credit).into(credBtn)
        Glide.with(this).load(R.drawable.instruction).into(insBtn)


        lv1.setImageDrawable(this.resources.getDrawable(R.drawable.green_dot))
        lv2.setImageDrawable(this.resources.getDrawable(R.drawable.grey_dot))
        rv1.setImageDrawable(this.resources.getDrawable(R.drawable.grey_dot))
        rv2.setImageDrawable(this.resources.getDrawable(R.drawable.grey_dot))

        flush.setOnClickListener(this)
        leftValve.setOnClickListener(this)
        rightValve.setOnClickListener(this)
        freshValve1.setOnClickListener(this)
        freshValve2.setOnClickListener(this)
        lv1.setOnClickListener(this)
        noBtn.setOnClickListener(this)
        external.setOnClickListener(this)
        pump.setOnClickListener(this)
        credBtn.setOnClickListener(this)
        insBtn.setOnClickListener(this)

        indicator6.visibility = View.GONE


        startTimer()

    }

    override fun onResume() {
        super.onResume()

        val decorView = window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)


    }

    override fun onClick(v: View?) {
        if (v!!.equals(flush)) {
            if (ovr > 0) {
                Glide.with(this).load(R.drawable.flush_turn_copy).into(flush)
                Glide.with(this).load(R.drawable.arrow_yellow_down).into(yellow1)

                decreaseFromOvr()

                if (isLeftValveOpen) {
                    if (ovr > 0) {
                        Glide.with(this).load(R.drawable.arrow_yellow_left).into(yellow2)
                        Glide.with(this).load(R.drawable.arrow_yellow_down).into(yellow4)
                        startTimeL = System.currentTimeMillis()
                        addUg(ugQuanL1)
                        lv1.setOnClickListener(null)
                        lv1.setImageDrawable(this.resources.getDrawable(R.drawable.yellow_dot))
                        openV1(lv1)
                    }
                }
                if (isRightValveOpen) {
                    if (ovr > 0) {
                        Glide.with(this).load(R.drawable.arrow_yellow_right).into(yellow3)
                        startTimeR = System.currentTimeMillis()
                        addUg(ugQuanR1)
                        rv1.setOnClickListener(null)
                        rv1.setImageDrawable(this.resources.getDrawable(R.drawable.yellow_dot))
                        openV1(rv1)
                    }
                }

                if (mp.isPlaying) {
                    mp.reset()
                    mp = MediaPlayer.create(this, R.raw.flush_sound)
                }
                mp.start()
                leftValve.setOnClickListener(null)
                rightValve.setOnClickListener(null)
                freshValve1.setOnClickListener(null)
                freshValve2.setOnClickListener(null)
                mp.setOnCompletionListener(MediaPlayer.OnCompletionListener {
                    Glide.with(this).load(R.drawable.arrow_grey_down).into(yellow1)
                    Glide.with(this).load(R.drawable.arrow_grey_left).into(yellow2)
                    Glide.with(this).load(R.drawable.arrow_grey_right).into(yellow3)
                    Glide.with(this).load(R.drawable.arrow_grey_down).into(yellow4)
                    Glide.with(this).load(R.drawable.flushcopy).into(flush)
                    leftValve.setOnClickListener(this)
                    rightValve.setOnClickListener(this)
                    freshValve1.setOnClickListener(this)
                    freshValve2.setOnClickListener(this)
                })
            }
        }
        else if (v!!.equals(leftValve)) {
            isLeftValveOpen = !isLeftValveOpen
            isRightValveOpen = !isRightValveOpen
            if (isLeftValveOpen) {
                Glide.with(this).load(R.drawable.green_ring).into(indicator2)
                Glide.with(this).load(R.drawable.red_ring).into(indicator1)
            } else {
                Glide.with(this).load(R.drawable.red_ring).into(indicator2)
                Glide.with(this).load(R.drawable.green_ring).into(indicator1)
            }
        }
        else if (v!!.equals(rightValve)) {
            isRightValveOpen = !isRightValveOpen
            isLeftValveOpen = !isLeftValveOpen
            if (isRightValveOpen) {
                Glide.with(this).load(R.drawable.green_ring).into(indicator1)
                Glide.with(this).load(R.drawable.red_ring).into(indicator2)
            } else {
                Glide.with(this).load(R.drawable.red_ring).into(indicator1)
                Glide.with(this).load(R.drawable.green_ring).into(indicator2)
            }
        }
        else if (v!!.equals(freshValve1)) {
            isFresh1Open = !isFresh1Open
            if (isFresh1Open) {
                Glide.with(this).load(R.drawable.green_ring).into(indicator4)
                Glide.with(this).load(R.drawable.arrow_blue_right).into(blue4)
                if (isDraining)
                    drain()
            } else {
                Glide.with(this).load(R.drawable.red_ring).into(indicator4)
                Glide.with(this).load(R.drawable.arrow_grey_right).into(blue4)
            }
        }
        else if (v!!.equals(freshValve2)) {
            isFresh2Open = !isFresh2Open
            if (isFresh2Open) {
                Glide.with(this).load(R.drawable.green_ring).into(indicator3)
                Glide.with(this).load(R.drawable.arrow_blue_right).into(blue3)
                if (isDraining)
                    drain()
            } else {
                Glide.with(this).load(R.drawable.red_ring).into(indicator3)
                Glide.with(this).load(R.drawable.arrow_grey_right).into(blue3)
            }
        }
        else if (v!!.equals(lv1)) {
            lv1.setOnClickListener(null)
            Toast.makeText(this, "Released", Toast.LENGTH_SHORT).show()
            var temp = ul1
            for (a in 1..ul1)
            {
                if(a==1)
                    makeScreenUnresponsive()
                Handler().postDelayed({
                    ul2++
                    ugQuanL2.text = ul2.toString()
                    temp--
                    ugQuanL1.text = temp.toString()
                    if (a == ul1) {
                        ul1 = 0
                        lv1.setImageDrawable(this.resources.getDrawable(R.drawable.grey_dot))
                        lv2.setImageDrawable(this.resources.getDrawable(R.drawable.yellow_dot))
                        startTimeL2 = System.currentTimeMillis()
                        lv2.setOnClickListener(null)
                        openV2(lv2)
                        lv1.setOnClickListener(this)
                        makeWindowResponsive()
                    }
                }, a * 10L)

            }
        }
        else if (v!!.equals(lv2)) {
            lv2.setOnClickListener(null)
            var temp = ul2
            for (a in 1..ul2) {
                if(a==1)
                    makeScreenUnresponsive()
                Handler().postDelayed({
                    ul3++
                    ugQuanL3.text = ul3.toString()
                    temp--
                    ugQuanL2.text = temp.toString()
                    if (a == ul2) {
                        ul2 = 0
                        lv2.setImageDrawable(this.resources.getDrawable(R.drawable.grey_dot))
                        lv2.setOnClickListener(this)
                        makeWindowResponsive()
                    }
                }, a * 10L)

            }
        }
        else if (v!!.equals(rv1)) {
            rv1.setOnClickListener(null)
            Toast.makeText(this, "Released", Toast.LENGTH_SHORT).show()
            var temp = ur1
            for (a in 1..ur1) {
                if(a==1)
                    makeScreenUnresponsive()
                Handler().postDelayed({
                    ur2++
                    ugQuanR2.text = ur2.toString()
                    temp--
                    ugQuanR1.text = temp.toString()
                    if (a == ur1) {
                        ur1 = 0
                        rv1.setImageDrawable(this.resources.getDrawable(R.drawable.grey_dot))
                        rv2.setImageDrawable(this.resources.getDrawable(R.drawable.yellow_dot))
                        startTimeR2 = System.currentTimeMillis()
                        rv2.setOnClickListener(null)
                        openV2(rv2)
                        rv1.setOnClickListener(this)
                        makeWindowResponsive()
                    }
                }, a * 10L)

            }
        }
        else if (v!!.equals(rv2)) {
            rv2.setOnClickListener(null)
            var temp = ur2
            for (a in 1..ur2) {
                if(a==1)
                    makeScreenUnresponsive()
                Handler().postDelayed({
                    ur3++
                    ugQuanR3.text = ur3.toString()
                    temp--
                    ugQuanR2.text = temp.toString()
                    if (a == ur2) {
                        ur2 = 0
                        rv2.setImageDrawable(this.resources.getDrawable(R.drawable.grey_dot))
                        rv2.setOnClickListener(this)
                        makeWindowResponsive()
                    }
                }, a * 10L)

            }
        }
        else if (v!!.equals(noBtn)) {
            if (isFresh1Open || isFresh2Open) {
                isDraining = true
                drain()
            }
        }
        else if (v.equals(external)) {
            fillOvr()
        }
        else if (v!!.equals(pump))
        {
            if(isFresh1Open && isFresh2Open)
            {
                msg.text="WASTE WATER MIXED"
            }
            else if((isFresh1Open && isLeftValveOpen) || (isFresh2Open && isRightValveOpen))
            {
                msg.text="WASTE WATER OPEN"
            }
            else if(ovr>=2000)
            {
                msg.text="TANK FULL"
            }
            else if(!isFresh1Open && !isFresh2Open)
            {
                msg.text="VALVE NOT OPEN"
            }
            else
            {
                msg.text="STATUS: OK"
                reuseWater()
            }
        }
        else if(v.equals(credBtn))
        {
            startActivity(Intent(this,Credits::class.java))
        }
        else if(v.equals(insBtn))
        {
            startActivity(Intent(this,Instructions::class.java))
        }

    }


    fun startTimer() {
        for (a in 0..23) {
            Handler().postDelayed({
                for (b in 0..59) {
                    Handler().postDelayed({
                        if (a < 10 && b < 10)
                            time.text = "0" + a.toString() + ":0" + b.toString()
                        else if (a < 10 && b >= 10)
                            time.text = "0" + a.toString() + ":" + b.toString()
                        else if (a >= 10 && b < 10)
                            time.text = a.toString() + ":0" + b.toString()
                        else
                            time.text = a.toString() + ":" + b.toString()
                        if (a == 23 && b == 59)
                            startTimer()
                    }, (b + 1) * (1000L / 60))
                }

            }, (a + 1) * 1000L)
        }


    }

    fun decreaseFromOvr() {
        makeScreenUnresponsive()
        for (a in 1..4) {
            Handler().postDelayed({
                if (ovr > 0) {
                    ovr--
                    upperQuan.text = ovr.toString() + " Ltr"
                }
                if (a == 4)
                    makeWindowResponsive()

            }, a * 100L)
        }
    }

    fun addUg(v: View?) {
        makeScreenUnresponsive()
        if (v!!.equals(ugQuanL1)) {
            for (a in 1..4) {
                Handler().postDelayed({
                    ul1++
                    ugQuanL1.text = ul1.toString()
                    if (a == 4)
                        makeWindowResponsive()
                }, a * 10L)
            }
        } else if (v!!.equals(ugQuanR1)) {
            for (a in 1..4) {
                Handler().postDelayed({
                    ur1++
                    ugQuanR1.text = ur1.toString()
                    if (a == 4)
                        makeWindowResponsive()
                }, a * 10L)
            }
        }
    }

    fun openV1(v: ImageButton?) {
        if (v!!.equals(lv1)) {
            Handler().postDelayed({
                currentTimeL = System.currentTimeMillis()
                if (currentTimeL - startTimeL >= 16000) {
                    v!!.setImageDrawable(this.resources.getDrawable(R.drawable.green_dot))
                    v.setOnClickListener(this)
                }
            }, 16000)
        } else if (v!!.equals(rv1)) {
            Handler().postDelayed({
                currentTimeR = System.currentTimeMillis()
                if (currentTimeR - startTimeR >= 16000) {
                    v.setImageDrawable(this.resources.getDrawable(R.drawable.green_dot))
                    v.setOnClickListener(this)
                }
            }, 16000)
        }
    }

    fun openV2(v: ImageButton?) {
        if (v!!.equals(lv2)) {
            Handler().postDelayed({
                currentTimeL2 = System.currentTimeMillis()
                if (currentTimeL2 - startTimeL2 >= 4000) {
                    v.setImageDrawable(this.resources.getDrawable(R.drawable.green_dot))
                    v.setOnClickListener(this)
                }
            }, 4000)
        } else if (v!!.equals(rv2)) {
            Handler().postDelayed({
                currentTimeR2 = System.currentTimeMillis()
                if (currentTimeR2 - startTimeR2 >= 4000) {
                    v.setImageDrawable(this.resources.getDrawable(R.drawable.green_dot))
                    v.setOnClickListener(this)
                }
            }, 4000)
        }
    }

    fun drain()
    {
        //Toast.makeText(this,"clicked",Toast.LENGTH_SHORT).show()
        var b1: Boolean = true
        var b2: Boolean = true
        var mpDrain: MediaPlayer
        mpDrain= MediaPlayer.create(this,R.raw.brook)
        if (isFresh1Open)
        {
            b1 = false
            var temp = ul3
            for (a in 1..ul3)
            {
                makeScreenUnresponsive()
                noBtn.setOnClickListener(null)
                if(!mpDrain.isPlaying)
                {
                    mpDrain.start()
                    mpDrain.isLooping=true
                }
                Handler().postDelayed({
                    temp--
                    ugQuanL3.text = temp.toString()
                    if ((a * 10L) % 2000 == 0L) {
                        Glide.with(this).load(R.drawable.arrow_grey_right).into(red1)
                        Glide.with(this).load(R.drawable.trans_blue).into(trans)
                    } else if ((a * 10L) % 1000L == 0L) {
                        Glide.with(this).load(R.drawable.arrow_red_copy).into(red1)
                        Glide.with(this).load(R.drawable.trans_grey).into(trans)
                    }
                    if (a == ul3) {
                        b1 = true
                        if (b1 && b2) {
                            mpDrain.stop()
                            mpDrain.release()
                            makeWindowResponsive()
                            for (b in 1..6) {
                                Handler().postDelayed({
                                    if (b % 2 == 0) {
                                        indicator6.visibility = View.GONE
                                    } else {
                                        indicator6.visibility = View.VISIBLE
                                    }
                                }, b * 1000L)
                            }
                        }
                        ul3 = 0
                        isDraining = false
                        Glide.with(this).load(R.drawable.arrow_grey_right).into(red1)
                        Glide.with(this).load(R.drawable.trans_grey).into(trans)
                        noBtn.setOnClickListener(this)
                    }
                }, a * 10L)
            }
        }
        if (isFresh2Open)
        {
            b2=false
            var temp = ur3
            for (a in 1..ur3)
            {
                makeScreenUnresponsive()
                noBtn.setOnClickListener(null)
                if(!mpDrain.isPlaying)
                {
                    mpDrain.start()
                    mpDrain.isLooping=true
                }
                Handler().postDelayed({
                    temp--
                    ugQuanR3.text = temp.toString()
                    if ((a * 10L) % 2000 == 0L) {
                        Glide.with(this).load(R.drawable.arrow_grey_right).into(red1)
                        Glide.with(this).load(R.drawable.trans_blue).into(trans)
                    } else if ((a * 10L) % 1000L == 0L) {
                        Glide.with(this).load(R.drawable.arrow_red_copy).into(red1)
                        Glide.with(this).load(R.drawable.trans_grey).into(trans)
                    }
                    if (a == ur3) {
                        b2 = true
                        if (b1 && b2) {
                            mpDrain.stop()
                            mpDrain.release()
                            makeWindowResponsive()
                            for (b in 1..6) {
                                Handler().postDelayed({
                                    if (b % 2 == 0) {
                                        indicator6.visibility = View.GONE
                                    } else {
                                        indicator6.visibility = View.VISIBLE
                                    }
                                }, b * 1000L)
                            }
                        }
                        ur3 = 0
                        isDraining = false
                        Glide.with(this).load(R.drawable.arrow_grey_right).into(red1)
                        Glide.with(this).load(R.drawable.trans_grey).into(trans)
                        noBtn.setOnClickListener(this)
                    }
                }, a * 10L)
            }
        }
    }

    fun makeScreenUnresponsive() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }

    fun makeWindowResponsive() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    fun fillOvr()
    {
        var mpBig: MediaPlayer
        mpBig= MediaPlayer.create(this,R.raw.oceanlap)
        if (ovr < 2000) {
            makeScreenUnresponsive()
            mpBig.start()
            mpBig.isLooping=true

        }
        var ini = ovr
        for (a in ovr + 1..2000) {
            Handler().postDelayed({
                ovr++
                upperQuan.text = ovr.toString() + " Ltr"
                if (a == 2000) {
                    makeWindowResponsive()
                    mpBig.stop()
                    mpBig.release()
                }
            }, (a - ini) * 10L)
        }
    }

    fun reuseWater()
    {
        var mpPump: MediaPlayer
        mpPump=MediaPlayer.create(this,R.raw.pump_running)
        if (isFresh1Open)
        {
            var temp = ul3
            var count=0
            var t=Math.min(2000-ovr,ul3)
            for (a in 1..t)
            {
                if(a==1)
                {
                    makeScreenUnresponsive()
                    Glide.with(this).load(R.drawable.green_ring).into(indicator5)
                    noBtn.setOnClickListener(null)
                    mpPump.start()
                    mpPump.isLooping=true
                }
                count++
                Handler().postDelayed({
                    temp--
                    ugQuanL3.text = temp.toString()
                    ovr++
                    upperQuan.text=ovr.toString()+" Ltr"
                    if ((a * 10L) % 2000 == 0L)
                    {
                        Glide.with(this).load(R.drawable.arrow_green_up).into(green1)
                        Glide.with(this).load(R.drawable.arrow_grey_up).into(blue5)
                        Glide.with(this).load(R.drawable.arrow_grey_left).into(blue6)
                    } else if ((a * 10L) % 1000L == 0L) {
                        Glide.with(this).load(R.drawable.arrow_grey_up).into(green1)
                        Glide.with(this).load(R.drawable.arrow_blue_up).into(blue5)
                        Glide.with(this).load(R.drawable.arrow_blue_left).into(blue6)
                    }
                    if (a ==t) {

                            makeWindowResponsive()
                        mpPump.stop()
                        mpPump.release()


                        ul3 = ul3-count
                        Glide.with(this).load(R.drawable.arrow_grey_up).into(green1)
                        Glide.with(this).load(R.drawable.arrow_grey_up).into(blue5)
                        Glide.with(this).load(R.drawable.arrow_grey_left).into(blue6)
                        Glide.with(this).load(R.drawable.red_ring).into(indicator5)

                    }
                }, a * 10L)
            }
        }
        else if (isFresh2Open)
        {
            var temp = ur3
            var count=0
            var t=Math.min(2000-ovr,ur3)
            for (a in 1..t)
            {
                if(a==1)
                {
                    makeScreenUnresponsive()
                    Glide.with(this).load(R.drawable.green_ring).into(indicator5)
                    noBtn.setOnClickListener(null)
                    mpPump.start()
                    mpPump.isLooping=true
                }
                count++
                Handler().postDelayed({
                    temp--
                    ugQuanR3.text = temp.toString()
                    ovr++
                    upperQuan.text=ovr.toString()+" Ltr"
                    if ((a * 10L) % 2000 == 0L)
                    {
                        Glide.with(this).load(R.drawable.arrow_green_up).into(green1)
                        Glide.with(this).load(R.drawable.arrow_grey_up).into(blue5)
                        Glide.with(this).load(R.drawable.arrow_grey_left).into(blue6)
                    } else if ((a * 10L) % 1000L == 0L) {
                        Glide.with(this).load(R.drawable.arrow_grey_up).into(green1)
                        Glide.with(this).load(R.drawable.arrow_blue_up).into(blue5)
                        Glide.with(this).load(R.drawable.arrow_blue_left).into(blue6)
                    }
                    if (a == t) {

                        makeWindowResponsive()
                        mpPump.stop()
                        mpPump.release()


                        ur3 = ur3-count
                        Glide.with(this).load(R.drawable.arrow_grey_up).into(green1)
                        Glide.with(this).load(R.drawable.arrow_grey_up).into(blue5)
                        Glide.with(this).load(R.drawable.arrow_grey_left).into(blue6)
                        Glide.with(this).load(R.drawable.red_ring).into(indicator5)

                    }
                }, a * 10L)
            }
        }
    }
}
