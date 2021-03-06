package mx.edu.utng.franciscojs.answers.quizDos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.franciscojs.answers.Question;


public class QuizJsDos extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "persisten";
	// tasks table name
	private static final String TABLE_QUEST = "quest";
	// tasks Table Columns names
	private static final String KEY_ID = "qid";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; // respuesta correcta
	private static final String KEY_OPTA = "opta"; // opcion a
	private static final String KEY_OPTB = "optb"; // opcion b
	private static final String KEY_OPTC = "optc"; // opcion c

	private SQLiteDatabase dbase;

	public QuizJsDos(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase = db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
				+ KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
		db.execSQL(sql);
		addQuestion();
		// db.close();
	}

	private void addQuestion() {
		Question q1 = new Question("¿Donde se recomienda incluir el codigo Script?",
				"Al final",
				"Donde se quiera poner",
				"Al principio",
				"Al principio");
		this.addQuestion(q1);

		Question q2 = new Question("Que es MIME?",
				"Es un estandar para los diferentes tipos de contenidos",
				"Es un compilador",
				"Es un Jar",
				"Es un estandar para los diferentes tipos de contenidos");
		this.addQuestion(q2);

		Question q3 = new Question("¿Para que una pagina sea validada que es necesario definir?",
				"Un atributo Type",
				"Un alert",
				"Un Jar",
				"Un atributo Type");
		this.addQuestion(q3);

		Question q4 = new Question("¿Completa el siguiente codigo (alert(Hola Mundo)?",
				":",
				")",
				";",
				";");
		this.addQuestion(q4);


		Question q5 = new Question("¿Cual es el MIME correcto para JavaScript?",
				"text/javascri",
				"tex/javascript",
				"text/javascript",
				"text/javascript");
		this.addQuestion(q5);


	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}

	// Adding new question
	public void addQuestion(Question quest) {
		// SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());

		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);
	}

	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT * FROM " + TABLE_QUEST;
		dbase = this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));

				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}


}
