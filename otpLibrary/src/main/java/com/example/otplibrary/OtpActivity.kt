package com.example.otplibrary

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.otplibrary.databinding.ActivityOtpBinding

class OtpActivity : AppCompatActivity() {
   private  var resultData :Int = 0
    private lateinit var resultIntent: Intent
    private lateinit var binding :ActivityOtpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_otp)

         resultIntent = Intent()

        binding.buttonGetOtp.setOnClickListener {
          if (!getOtp()){
              Toast.makeText(this,"please assure that the otp is more than or equals 3",Toast.LENGTH_LONG).show()
          }
            else{
                finish()
          }
        }
    }




  private  fun getOtp() :Boolean{

        if (binding.editTextOtp.text.isEmpty() || binding.editTextOtp.text.length<3){
            return false
        }else{
            resultData = binding.editTextOtp.text.toString().toInt()
            resultIntent.putExtra(RESULT_KEY,resultData)
            setResult(Activity.RESULT_OK,resultIntent)
            return true
        }
    }

    companion object{
      const val  RESULT_KEY = "res"
    }
}