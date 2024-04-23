package com.example.dadishymns;

import android.widget.Button;
import android.widget.EditText;

import com.example.dadishymns.AddActivity;
import com.example.dadishymns.DBHandler;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitTests_AddActivity{

    private AddActivity addActivity;
    private DBHandler dbHandler;
    private EditText numberInput, titleInput, favoriteInput, contentInput;
    private Button addButton;

    @Before
    public void setUp() {
        addActivity = new AddActivity();

        // Mock dependencies
        dbHandler = mock(DBHandler.class);
        numberInput = mock(EditText.class);
        titleInput = mock(EditText.class);
        favoriteInput = mock(EditText.class);
        contentInput = mock(EditText.class);
        addButton = mock(Button.class);
        dbHandler = mock(DBHandler.class);

        // Set dependencies
        addActivity.number_input = numberInput;
        addActivity.title_input = titleInput;
        addActivity.favorite_input = favoriteInput;
        addActivity.content_input = contentInput;
        addActivity.add_button = addButton;
//        addActivity.myDB = dbHandler;
    }

    @Test
    public void testAddButtonClicked() {
        // Set up mock EditText values
        when(numberInput.getText().toString()).thenReturn("123");
        when(titleInput.getText().toString()).thenReturn("Test Title");
        when(contentInput.getText().toString()).thenReturn("Test Content");

        // Simulate button click
        addButton.performClick();

        // Verify that addBook method is called with correct parameters
        verify(dbHandler).addBook("123", "Test Title", "Test Content");
    }

    // You can write more test cases to cover different scenarios
}


