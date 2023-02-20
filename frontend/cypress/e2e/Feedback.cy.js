
describe('My First Test', () => {
  it('visits the app root url', () => {
    cy.visit('/feedback')

    cy.get('#nameInput').type('myuser')
    cy.get('#emailInput').type('mypassword@gmail.com')
    cy.get('#messageInput').type('feedback')
    cy.get('#submit_button').click()

    cy.contains("<p>", "Thanks for your feedback")

  })

  it('Sjekker at knappen er disabled hvis informasjonen ikke er fylt ut', () => {
    cy.visit('/feedback')

    cy.get('#nameInput').type('myuser')
    cy.get('#messageInput').type('feedback')
    cy.get('#submit_button').should('be.disabled')
  })
})
