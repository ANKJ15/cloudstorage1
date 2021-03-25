package cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "submit-logout")
    private WebElement logoutSubmit;


    //-----------------------------------------Notes------------------------------------------------//
    @FindBy(id = "nav-notes-tab")
    private WebElement notesTab;

    @FindBy(id = "submit-note")
    private WebElement noteModal;

    @FindBy(id = "note-title")
    private WebElement NoteTitle;

    @FindBy(id = "note-description")
    private WebElement NoteDescription;

    @FindBy(id = "noteSubmit1")
    private WebElement NoteSubmit;

    @FindBy(id = "editnoteess")
    private WebElement editNote;




//-----------------------------------------Credentials------------------------------------------------//




    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        this.logoutSubmit.click();
    }









    //-----------------------------------------Notes------------------------------------------------//

    public void submitNote(String noteTitle,String noteDescription) {
        NoteTitle.sendKeys(noteTitle);
        NoteDescription.sendKeys(noteDescription);
        this.NoteSubmit.click();
    }
    public void editNote(String noteTitle, String noteDescription) {
        editNote.click();


        NoteTitle.sendKeys(noteTitle);
        NoteDescription.sendKeys(noteDescription);
        this.NoteSubmit.click();

    }

    public void openNoteTap()
    {
        this.notesTab.click();
    }

    public void openNoteModal()
    {
        this.noteModal.click();
    }

}
