package org.example.exam_questions.serviceExam;

import org.example.exam_questions.questionExam.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService{
    private final List<Question> questions = new ArrayList<>();
    private final Random random = new Random();


    public JavaQuestionService() {

    }


    public void initializeDefaultQuestions() {
        questions.add(new Question("Что такое интерфейс в Java?", "Это контракт, который описывает методы, которые класс должен реализовать"));
        questions.add(new Question("Чем отличается абстрактный класс от интерфейса?", "Абстрактный класс может иметь состояние (поля) и частичную реализацию, интерфейс — только контракт (до Java 8/9)"));
        questions.add(new Question("Что означает аннотация @Service?", "Она помечает класс как компонент бизнес-логики, который Spring может внедрять через DI"));
        questions.add(new Question("Зачем нужна аннотация @Override?", "Для явного указания переопределения метода и проверки компилятором"));
        questions.add(new Question("Как обработать ситуацию, когда товара нет в корзине?", "Выбросить собственное исключение, например, NoSuchProductException"));
        questions.add(new Question("В чём разница между List и Set?", "List допускает дубликаты и хранит порядок, Set уникален и порядок не гарантирует (по умолчанию)"));
        questions.add(new Question("Что такое UUID и зачем он нужен?", "Universally Unique Identifier — уникальный идентификатор, чтобы не было конфликтов ID у разных объектов"));
        questions.add(new Question("Что произойдёт, если вызвать removeIf на пустом списке?", "Ничего не произойдёт, метод вернёт false, исключений не будет"));
        questions.add(new Question("Зачем возвращать копию списка в методе getAll()?", "Чтобы защитить внутреннее состояние сервиса от изменений извне (инкапсуляция)"));
        questions.add(new Question("Что делает Collections.shuffle()?", "Случайно перемешивает элементы в списке"));
    }
    @Override
    public void add(Question question) {
        questions.add(question);
    }

    @Override
    public boolean remove(String id) {
        // удаляем первый найденный вопрос с таким id
        return questions.removeIf(q -> q.getId().equals(id));
    }

    @Override
    public List<Question> getAll() {
        // возвращаем копию, чтобы внешний код не мог модифицировать внутренний список
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }

}