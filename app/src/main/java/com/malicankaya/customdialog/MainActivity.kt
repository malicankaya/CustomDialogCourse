package com.malicankaya.customdialog

import android.Manifest
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ibSnackbar: ImageButton = findViewById(R.id.ibSnackbar)
        val btnAlertDialog: Button = findViewById(R.id.btnAlertDialog)
        val btnCustomDialog: Button = findViewById(R.id.btnCustomDialog)
        val btnCustomProgressDialog: Button = findViewById(R.id.btnCustomProgressDialog)

        ibSnackbar.setOnClickListener {
            Snackbar.make(it, "You have cliked image button.", Snackbar.LENGTH_SHORT).show()
        }

        btnAlertDialog.setOnClickListener {
            alertDialogFunction()
        }

        btnCustomDialog.setOnClickListener {
            customDialogFunction()
        }
        btnCustomProgressDialog.setOnClickListener {
            customProgressDialogFunction()
        }
    }

    private fun customProgressDialogFunction() {
        val customProgressDialog= Dialog(this)

        customProgressDialog.setContentView(R.layout.dialog_custom_progress)

        customProgressDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customProgressDialog.show()
    }

    private fun customDialogFunction() {
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.dialog_custom)

        val tvCustomDialogSubmit: TextView = customDialog.findViewById(R.id.tvCustomDialogSubmit)
        val tvCustomDialogCancel: TextView = customDialog.findViewById(R.id.tvCustomDialogCancel)

        tvCustomDialogSubmit.setOnClickListener {
            Toast.makeText(applicationContext,"clicked submit",Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }
        tvCustomDialogCancel.setOnClickListener {
            Toast.makeText(applicationContext,"clicked cancel",Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }

        customDialog.show()
    }

    private fun alertDialogFunction() {
        val builder = AlertDialog.Builder(this);

        builder.setTitle("Alert")
        builder.setMessage("This is Alert Dialog. Which is used to show alert")
        builder.setIcon(R.drawable.ic_alert)


        builder.setPositiveButton("Yes") { dialogInterface, which ->
            Toast.makeText(applicationContext, "Clicked yes", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("No") { dialogInterface, which ->
            Toast.makeText(applicationContext, "Clicked no", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        builder.setNeutralButton("Cancel") { dialogInterface, which ->
            Toast.makeText(applicationContext, "Clicked cancel", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        val alertDialog: AlertDialog = builder.create()

        alertDialog.setCancelable(false)
        alertDialog.show()
    }




}
