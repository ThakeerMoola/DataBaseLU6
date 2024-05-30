package com.example.databaselu6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import android.content.Context

    lateinit var db: FirebaseFirestore



class MainActivity : AppCompatActivity() {


    fun showAlert(context: Context, message: String) {
        AlertDialog.Builder(context)
            .setMessage(message)
            .setPositiveButton("ok", null)
            .show()


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Firebase.firestore


    }

    fun button_DB(view: View) {

        val user = hashMapOf(
            "Name" to "Ada",
            "Surname" to "Lovelace",
            "Year" to 1815
        )

        db.collection("users").document("user2")
            .set(user)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(
                    applicationContext,
                    "DocumentSnapshot added with ID: ${documentReference}",
                    Toast.LENGTH_LONG
                ).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(
                    applicationContext,
                    "There was an error creating the database",
                    Toast.LENGTH_LONG
                ).show()
            }
        val user2 = hashMapOf(
            "Name" to "Thakeer",
            "Surname" to "Moola",
            "Year" to 2001
        )

        db.collection("users").document("user1")
            .set(user2)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(
                    applicationContext,
                    "DocumentSnapshot added with ID: ${documentReference}",
                    Toast.LENGTH_LONG
                ).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(
                    applicationContext,
                    "There was an error creating the database",
                    Toast.LENGTH_LONG
                ).show()
            }

        val user3 = hashMapOf(
            "Name" to "Tauhirah",
            "Surname" to "Osman",
            "Year" to 2003
        )

        db.collection("users").document("user3")
            .set(user3)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(
                    applicationContext,
                    "DocumentSnapshot added with ID: ${documentReference}",
                    Toast.LENGTH_LONG
                ).show()
            }

        val user4 = hashMapOf(
            "Name" to "Farouk",
            "Surname" to "Moola",
            "Year" to 1968
        )

        db.collection("users").document("user4")
            .set(user4)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(
                    applicationContext,
                    "DocumentSnapshot added with ID: ${documentReference}",
                    Toast.LENGTH_LONG
                ).show()
            }


    }

    fun DB_INFO(view: View) {

        /*db.collection("users").whereEqualTo("Year", 2001)
            .get()
            .addOnSuccessListener { result ->
                var returnedValue = result.documents

                for (document in returnedValue) {
                    if (returnedValue == null) {
                        showAlert(this, "no document found!")
                    } else {
                        showAlert(this, "the ID of the user born in 2001 is: ${document.id}")*/

        db.collection("users").whereLessThan("Year", 2004)
            .get()
            .addOnSuccessListener { result ->
                var returnedValue = result.documents

                for (document in returnedValue) {
                    if (returnedValue == null) {
                        showAlert(this, "no document found!")
                    } else {
                        showAlert(this, "the ID of the user born in 2001 is: ${document.id}")
                    }
                }
            }
    }
}