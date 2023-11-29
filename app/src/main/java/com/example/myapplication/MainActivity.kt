package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db= Firebase.firestore
        binding.adddata.setOnClickListener(){
            val user= hashMapOf(
                "name" to binding.name.text.toString(),
                "password" to binding.password.text.toString(),
            )
            Toast.makeText(this, binding.name.text.toString(), Toast.LENGTH_SHORT).show()
            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
//                    Toast.makeText(this, "DocumentSnapshot added with ID: ${documentReference.id}", Toast.LENGTH_SHORT).show()

                }
                .addOnFailureListener { e ->
//                    Toast.makeText(this, "Error adding document: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()

                }
        }
        // Add a new document with a generated ID


    }
}