package com.example.taskmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tasks = findViewById<ListView>(R.id.tasks)
        val taskInput = findViewById<EditText>(R.id.taskInput)
        val addButton = findViewById<Button>(R.id.addButton)

        val todos = mutableListOf<String>()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos);
        tasks.adapter = adapter


        addButton.setOnClickListener {
            val text = taskInput.text.toString().trim()
            if (text != ""){
                adapter.insert(text, 0);
                taskInput.setText("")
            }
        }

        tasks.setOnItemClickListener { parent, view, position, id ->
            val taskName = tasks.getItemAtPosition(position).toString()
            adapter.remove(taskName)

            Toast.makeText(this, "Задача $taskName выполнена", Toast.LENGTH_LONG).show()
        }
    }
}