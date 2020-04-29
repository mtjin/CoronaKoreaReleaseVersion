package com.mtjin.coronakorea.utils

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatSpinner
import androidx.databinding.BindingAdapter
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.mtjin.coronakorea.R
import com.mtjin.coronakorea.data.city.CityResponse
import com.mtjin.coronakorea.data.country.CountryResponse
import com.mtjin.coronakorea.views.city.CityViewModel

//Country
@BindingAdapter("top5Values")
fun PieChart.setTop5ValuesChart(countryResponse: CountryResponse?) {
    countryResponse?.let {
        setUsePercentValues(true)
        description.isEnabled = false
        setExtraOffsets(5f, 10f, 5f, 5f)
        isDrawHoleEnabled = true
        setHoleColor(Color.WHITE)
        transparentCircleRadius = 61f

        val yValues: ArrayList<PieEntry> = ArrayList()
        with(yValues) {
            add(PieEntry(it.city1p.toFloat(), it.city1n))
            add(PieEntry(it.city2p.toFloat(), it.city2n))
            add(PieEntry(it.city3p.toFloat(), it.city3n))
            add(PieEntry(it.city4p.toFloat(), it.city4n))
            add(PieEntry(it.city5p.toFloat(), it.city5n))
            val remainPercent: Float =
                100 - it.city1p.toFloat() - it.city2p.toFloat() - it.city3p.toFloat() - it.city4p.toFloat() - it.city5p.toFloat()
            if (remainPercent.toInt() != 0) {
                add(
                    PieEntry(remainPercent, context.getString(R.string.remain_text))
                )
            }

        }
        animateY(1000, Easing.EaseInOutCubic)

        val dataSet: PieDataSet = PieDataSet(yValues, "")
        with(dataSet) {
            sliceSpace = 3f
            selectionShift = 5f
            setColors(*ColorTemplate.JOYFUL_COLORS)
        }

        val pieData: PieData = PieData(dataSet)
        with(pieData) {
            setValueTextSize(10f)
            setValueTextColor(Color.BLACK)
            val des = Description()
            des.text = "도시별 확진자 상위 5곳"
            description = des
        }
        data = pieData
    }
}

@BindingAdapter("cureOrDeadValues")
fun PieChart.setCureOrDeadValuesChart(countryResponse: CountryResponse?) {
    countryResponse?.let {
        setUsePercentValues(true)
        description.isEnabled = false
        setExtraOffsets(5f, 10f, 5f, 5f)
        isDrawHoleEnabled = true
        setHoleColor(Color.WHITE)
        transparentCircleRadius = 61f

        val yValues: ArrayList<PieEntry> = ArrayList()
        with(yValues) {
            add(
                PieEntry(
                    it.recoveredPercentage.toFloat(),
                    context.getString(R.string.country_cure_rate_text)
                )
            )
            add(
                PieEntry(
                    it.deathPercentage.toFloat(),
                    context.getString(R.string.country_death_rate_text)
                )
            )
            val remainPercent: Float =
                100 - it.deathPercentage.toFloat() - it.recoveredPercentage.toFloat()
            add(
                PieEntry(
                    remainPercent,
                    context.getString(R.string.etc_text)
                )
            )
        }

        animateY(1000, Easing.EaseInOutCubic)

        val dataSet: PieDataSet = PieDataSet(yValues, "")
        with(dataSet) {
            sliceSpace = 3f
            selectionShift = 5f
            setColors(*ColorTemplate.PASTEL_COLORS)
        }

        val pieData: PieData = PieData(dataSet)
        with(pieData) {
            setValueTextSize(10f)
            setValueTextColor(Color.BLACK)
            val des = Description()
            des.text = "국내 완치 및 사망 상대비율"
            description = des
        }
        data = pieData
    }
}

@BindingAdapter("positiveOrNegativeValues")
fun PieChart.setPositiveOrNegativeValuesChart(countryResponse: CountryResponse?) {
    countryResponse?.let {
        setUsePercentValues(true)
        description.isEnabled = false
        setExtraOffsets(5f, 10f, 5f, 5f)
        isDrawHoleEnabled = true
        setHoleColor(Color.WHITE)
        transparentCircleRadius = 61f

        val yValues: ArrayList<PieEntry> = ArrayList()
        with(yValues) {
            add(
                PieEntry(
                    it.checkingPercentage.toFloat(),
                    context.getString(R.string.checking_text)
                )
            )
            add(
                PieEntry(
                    it.casePercentage.toFloat(),
                    context.getString(R.string.corona_positive_text)
                )
            )
            add(
                PieEntry(
                    it.notcasePercentage.toFloat(),
                    context.getString(R.string.corona_negative_text)
                )
            )
        }

        animateY(1000, Easing.EaseInOutCubic)

        val dataSet: PieDataSet = PieDataSet(yValues, "")
        with(dataSet) {
            sliceSpace = 3f
            selectionShift = 5f
            setColors(*ColorTemplate.MATERIAL_COLORS)
        }

        val pieData: PieData = PieData(dataSet)
        with(pieData) {
            setValueTextSize(10f)
            setValueTextColor(Color.BLACK)
            val des = Description()
            des.text = "국내 검사결과"
            description = des
        }
        data = pieData
    }
}

//city
@BindingAdapter("selectedListener")
fun AppCompatSpinner.setSelectedListener(viewModel: CityViewModel) {
    onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {}

        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
            when (position) {
                1 -> viewModel.requestCity("korea")
                2 -> viewModel.requestCity("seoul")
                3 -> viewModel.requestCity("busan")
                4 -> viewModel.requestCity("chungbuk")
                5 -> viewModel.requestCity("chungnam")
                6 -> viewModel.requestCity("daegu")
                7 -> viewModel.requestCity("daejeon")
                8 -> viewModel.requestCity("gangwon")
                9 -> viewModel.requestCity("gwangju")
                10 -> viewModel.requestCity("gyeongbuk")
                11 -> viewModel.requestCity("gyeonggi")
                12 -> viewModel.requestCity("gyeongnam")
                13 -> viewModel.requestCity("incheon")
                14 -> viewModel.requestCity("jeju")
                15 -> viewModel.requestCity("jeonbuk")
                16 -> viewModel.requestCity("jeonnam")
                17 -> viewModel.requestCity("sejong")
                18 -> viewModel.requestCity("ulsan")
            }
        }
    }
}

@BindingAdapter("cityName")
fun TextView.setCityName(cityName: String?) {
    when (cityName) {
        "korea" -> text = "한국"
        "seoul" -> text = "서울"
        "busan" -> text = "부산"
        "chungbuk" -> text = "충북"
        "chungnam" -> text = "충남"
        "daegu" -> text = "대구"
        "daejeon" -> text = "대전"
        "gangwon" -> text = "강원"
        "gwangju" -> text = "광주"
        "gyeongbuk" -> text = "경북"
        "gyeonggi" -> text = "경기"
        "gyeongnam" -> text = "경남"
        "incheon" -> text = "인천"
        "jeju" -> text = "제주"
        "jeonbuk" -> text = "전북"
        "jeonnam" -> text = "전남"
        "sejong" -> text = "세종"
        "ulsan" -> text = "울산"
    }
}

@BindingAdapter("city", "newCase")
fun TextView.setNewCase(cityName: String?, cityResponse: CityResponse?) {
    cityResponse?.let {
        when (cityName) {
            "korea" -> text = cityResponse.korea.newCase
            "seoul" -> text = cityResponse.seoul.newCase
            "busan" -> text = cityResponse.busan.newCase
            "chungbuk" -> text = cityResponse.chungbuk.newCase
            "chungnam" -> text = cityResponse.chungnam.newCase
            "daegu" -> text = cityResponse.daegu.newCase
            "daejeon" -> text = cityResponse.daejeon.newCase
            "gangwon" -> text = cityResponse.gangwon.newCase
            "gwangju" -> text = cityResponse.gwangju.newCase
            "gyeongbuk" -> text = cityResponse.gyeongbuk.newCase
            "gyeonggi" -> text = cityResponse.gyeonggi.newCase
            "gyeongnam" -> text = cityResponse.gyeongnam.newCase
            "incheon" -> text = cityResponse.incheon.newCase
            "jeju" -> text = cityResponse.jeju.newCase
            "jeonbuk" -> text = cityResponse.jeonbuk.newCase
            "jeonnam" -> text = cityResponse.jeonnam.newCase
            "sejong" -> text = cityResponse.sejong.newCase
            "ulsan" -> text = cityResponse.ulsan.newCase
        }
    }
}

@BindingAdapter("city", "totalCase")
fun TextView.setTotalCase(cityName: String?, cityResponse: CityResponse?) {
    cityResponse?.let {
        when (cityName) {
            "korea" -> text = cityResponse.korea.totalCase
            "seoul" -> text = cityResponse.seoul.totalCase
            "busan" -> text = cityResponse.busan.totalCase
            "chungbuk" -> text = cityResponse.chungbuk.totalCase
            "chungnam" -> text = cityResponse.chungnam.totalCase
            "daegu" -> text = cityResponse.daegu.totalCase
            "daejeon" -> text = cityResponse.daejeon.totalCase
            "gangwon" -> text = cityResponse.gangwon.totalCase
            "gwangju" -> text = cityResponse.gwangju.totalCase
            "gyeongbuk" -> text = cityResponse.gyeongbuk.totalCase
            "gyeonggi" -> text = cityResponse.gyeonggi.totalCase
            "gyeongnam" -> text = cityResponse.gyeongnam.totalCase
            "incheon" -> text = cityResponse.incheon.totalCase
            "jeju" -> text = cityResponse.jeju.totalCase
            "jeonbuk" -> text = cityResponse.jeonbuk.totalCase
            "jeonnam" -> text = cityResponse.jeonnam.totalCase
            "sejong" -> text = cityResponse.sejong.totalCase
            "ulsan" -> text = cityResponse.ulsan.totalCase
        }
    }
}

@BindingAdapter("city", "recovered")
fun TextView.setRecovered(cityName: String?, cityResponse: CityResponse?) {
    cityResponse?.let {
        when (cityName) {
            "korea" -> text = cityResponse.korea.recovered
            "seoul" -> text = cityResponse.seoul.recovered
            "busan" -> text = cityResponse.busan.recovered
            "chungbuk" -> text = cityResponse.chungbuk.recovered
            "chungnam" -> text = cityResponse.chungnam.recovered
            "daegu" -> text = cityResponse.daegu.recovered
            "daejeon" -> text = cityResponse.daejeon.recovered
            "gangwon" -> text = cityResponse.gangwon.recovered
            "gwangju" -> text = cityResponse.gwangju.recovered
            "gyeongbuk" -> text = cityResponse.gyeongbuk.recovered
            "gyeonggi" -> text = cityResponse.gyeonggi.recovered
            "gyeongnam" -> text = cityResponse.gyeongnam.recovered
            "incheon" -> text = cityResponse.incheon.recovered
            "jeju" -> text = cityResponse.jeju.recovered
            "jeonbuk" -> text = cityResponse.jeonbuk.recovered
            "jeonnam" -> text = cityResponse.jeonnam.recovered
            "sejong" -> text = cityResponse.sejong.recovered
            "ulsan" -> text = cityResponse.ulsan.recovered
        }
    }
}

@BindingAdapter("city", "death")
fun TextView.setDeath(cityName: String?, cityResponse: CityResponse?) {
    cityResponse?.let {
        when (cityName) {
            "korea" -> text = cityResponse.korea.death
            "seoul" -> text = cityResponse.seoul.death
            "busan" -> text = cityResponse.busan.death
            "chungbuk" -> text = cityResponse.chungbuk.death
            "chungnam" -> text = cityResponse.chungnam.death
            "daegu" -> text = cityResponse.daegu.death
            "daejeon" -> text = cityResponse.daejeon.death
            "gangwon" -> text = cityResponse.gangwon.death
            "gwangju" -> text = cityResponse.gwangju.death
            "gyeongbuk" -> text = cityResponse.gyeongbuk.death
            "gyeonggi" -> text = cityResponse.gyeonggi.death
            "gyeongnam" -> text = cityResponse.gyeongnam.death
            "incheon" -> text = cityResponse.incheon.death
            "jeju" -> text = cityResponse.jeju.death
            "jeonbuk" -> text = cityResponse.jeonbuk.death
            "jeonnam" -> text = cityResponse.jeonnam.death
            "sejong" -> text = cityResponse.sejong.death
            "ulsan" -> text = cityResponse.ulsan.death
        }
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("city", "percentage")
fun TextView.setPercentage(cityName: String?, cityResponse: CityResponse?) {
    cityResponse?.let {
        when (cityName) {
            "korea" -> text = cityResponse.korea.percentage + "%"
            "seoul" -> text = cityResponse.seoul.percentage + "%"
            "busan" -> text = cityResponse.busan.percentage + "%"
            "chungbuk" -> text = cityResponse.chungbuk.percentage + "%"
            "chungnam" -> text = cityResponse.chungnam.percentage + "%"
            "daegu" -> text = cityResponse.daegu.percentage + "%"
            "daejeon" -> text = cityResponse.daejeon.percentage + "%"
            "gangwon" -> text = cityResponse.gangwon.percentage + "%"
            "gwangju" -> text = cityResponse.gwangju.percentage + "%"
            "gyeongbuk" -> text = cityResponse.gyeongbuk.percentage + "%"
            "gyeonggi" -> text = cityResponse.gyeonggi.percentage + "%"
            "gyeongnam" -> text = cityResponse.gyeongnam.percentage + "%"
            "incheon" -> text = cityResponse.incheon.percentage + "%"
            "jeju" -> text = cityResponse.jeju.percentage + "%"
            "jeonbuk" -> text = cityResponse.jeonbuk.percentage + "%"
            "jeonnam" -> text = cityResponse.jeonnam.percentage + "%"
            "sejong" -> text = cityResponse.sejong.percentage + "%"
            "ulsan" -> text = cityResponse.ulsan.percentage + "%"
        }
    }
}

@BindingAdapter("city", "newFcase")
fun TextView.setNewFcase(cityName: String?, cityResponse: CityResponse?) {
    cityResponse?.let {
        when (cityName) {
            "korea" -> text = cityResponse.korea.newFcase
            "seoul" -> text = cityResponse.seoul.newFcase
            "busan" -> text = cityResponse.busan.newFcase
            "chungbuk" -> text = cityResponse.chungbuk.newFcase
            "chungnam" -> text = cityResponse.chungnam.newFcase
            "daegu" -> text = cityResponse.daegu.newFcase
            "daejeon" -> text = cityResponse.daejeon.newFcase
            "gangwon" -> text = cityResponse.gangwon.newFcase
            "gwangju" -> text = cityResponse.gwangju.newFcase
            "gyeongbuk" -> text = cityResponse.gyeongbuk.newFcase
            "gyeonggi" -> text = cityResponse.gyeonggi.newFcase
            "gyeongnam" -> text = cityResponse.gyeongnam.newFcase
            "incheon" -> text = cityResponse.incheon.newFcase
            "jeju" -> text = cityResponse.jeju.newFcase
            "jeonbuk" -> text = cityResponse.jeonbuk.newFcase
            "jeonnam" -> text = cityResponse.jeonnam.newFcase
            "sejong" -> text = cityResponse.sejong.newFcase
            "ulsan" -> text = cityResponse.ulsan.newFcase
        }
    }
}

@BindingAdapter("city", "newCcase")
fun TextView.setNewCcase(cityName: String?, cityResponse: CityResponse?) {
    cityResponse?.let {
        when (cityName) {
            "korea" -> text = cityResponse.korea.newCcase
            "seoul" -> text = cityResponse.seoul.newCcase
            "busan" -> text = cityResponse.busan.newCcase
            "chungbuk" -> text = cityResponse.chungbuk.newCcase
            "chungnam" -> text = cityResponse.chungnam.newCcase
            "daegu" -> text = cityResponse.daegu.newCcase
            "daejeon" -> text = cityResponse.daejeon.newCcase
            "gangwon" -> text = cityResponse.gangwon.newCcase
            "gwangju" -> text = cityResponse.gwangju.newCcase
            "gyeongbuk" -> text = cityResponse.gyeongbuk.newCcase
            "gyeonggi" -> text = cityResponse.gyeonggi.newCcase
            "gyeongnam" -> text = cityResponse.gyeongnam.newCcase
            "incheon" -> text = cityResponse.incheon.newCcase
            "jeju" -> text = cityResponse.jeju.newCcase
            "jeonbuk" -> text = cityResponse.jeonbuk.newCcase
            "jeonnam" -> text = cityResponse.jeonnam.newCcase
            "sejong" -> text = cityResponse.sejong.newCcase
            "ulsan" -> text = cityResponse.ulsan.newCcase
        }
    }
}

