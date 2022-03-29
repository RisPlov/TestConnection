/*
 * %W% %E% Имя Фамилия
 *
 * Копирайт (c) 1993-1996 Sun Microsystems, Inc. Все права защищены.
 *
 * Это программное обеспечение является конфиденциальной и закрытой информацией Sun
 * Microsystems, Inc. («Конфиденциальная информация»). Вы не должены
 * раскрывать такую Конфиденциальную информацию и использовать ее только в
 * соответствии с условиями лицензионного соглашения, в которых вы состоите
 * с Sun.
 *
 * SUN НЕ ДАЁТ НИКАКИХ ГАРАНТИЙ, ЯВНЫХ ИЛИ КОСВЕННЫХ (ВКЛЮЧАЯ - НО НЕ
 * ОГРАНИЧИВАЯСЬ ИМИ - ГАРАНТИИ РЕАЛИЗУЕМОСТИ), СООТВЕТСТВИЯ ОПРЕДЕЛЁННОМУ
 * НАЗНАЧЕНИЮ ИЛИ НЕНАРУШЕНИЯ УСЛОВИЙ, ЧТО СОДЕРЖИМОЕ ДАННОЙ СПЕЦИФИКАЦИИ
 * ПОДХОДИТ ДЛЯ КАКИХ-ЛИБО ЦЕЛЕЙ ИЛИ ЧТО ЛЮБОЕ ИСПОЛЬЗОВАНИЕ ИЛИ РЕАЛИЗАЦИЯ
 * ТАКОГО СОДЕРЖИМОГО НЕ БУДЕТ НАРУШАТЬ КАКИХ-ЛИБО ПАТЕНТОВ ТРЕТЬЕЙ СТОРОНЫ,
 * АВТОРСКИХ ПРАВ, КОММЕРЧЕСКОЙ ТАЙНЫ ИЛИ ИНЫХ ПРАВ.
 */
package Application.Windows;

import Application.Commands.Ok;
import Application.Commands.UploadQuestionnaire;

import javax.swing.*;

public class WindowMenu extends JFrame {

    public static JButton dw = new JButton("Загрузить анкету ");/// кнопка "загрузить данные"
    static JButton fo = new JButton("Формирование отчета ");/// кнопка "формирование отчета"
    static JButton rd = new JButton("Изменение данных ");/// кнопка "изменение данных"
    static JButton pi = new JButton("Просмотр информации ");/// кнопка "просмотр информации"
    static JButton ex = new JButton("Выход ");/// скнопка "выход"

        public WindowMenu(){
            super("Меню"); //Заголовок окна
            setBounds(600, 400, 600, 400);//размер и положение
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа, иначе она останется висеть в процессах
            dw.setSize(200, 30);
            dw.setLocation(200, 50);
            fo.setSize(200, 30);
            fo.setLocation(200, 100);
            rd.setSize(200, 30);
            rd.setLocation(200, 150);
            pi.setSize(200, 30);
            pi.setLocation(200, 200);
            ex.setSize(200, 30);
            ex.setLocation(200, 250);
            JPanel contents = new JPanel(null);
            contents.add(dw);
            contents.add(fo);
            contents.add(rd);
            contents.add(pi);
            contents.add(ex);
            setContentPane(contents);
        }
    public static UploadQuestionnaire UQ = new UploadQuestionnaire();
}