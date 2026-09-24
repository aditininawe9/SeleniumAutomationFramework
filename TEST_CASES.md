# Test Cases

## Login

| ID | Test Scenario | Expected Result | Automated |
|---|---|---|---|
| TC-001 | Login with valid credentials | User is redirected to Products page | Yes |
| TC-002 | Login with invalid credentials | Appropriate error message is displayed | Yes |

## Products

| ID | Test Scenario | Expected Result | Automated |
|---|---|---|-----------|
| TC-003 | Verify products are displayed | Product list is displayed | Yes       |
| TC-004 | Verify product names | Product names are displayed correctly | Yes       |
| TC-005 | Select a product | Product details page is displayed | Yes       |
| TC-006 | Add product to cart | Product is added to cart | Yes       |
| TC-007 | Add multiple products to cart | All selected products are added | No        |
| TC-008 | Remove product from cart | Product is removed from cart | Yes       |
| TC-009 | Sort products A-Z | Products are sorted alphabetically | Yes       |
| TC-010 | Sort products Z-A | Products are sorted in reverse alphabetical order | Yes       |
| TC-011 | Sort products by price low-to-high | Products are sorted by ascending price | Yes       |
| TC-012 | Sort products by price high-to-low | Products are sorted by descending price | Yes       |