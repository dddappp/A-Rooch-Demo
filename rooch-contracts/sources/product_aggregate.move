// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module rooch_test_proj1::product_aggregate {
    use moveos_std::storage_context::StorageContext;
    use rooch_test_proj1::product;
    use rooch_test_proj1::product_create_logic;
    use std::string::String;

    public entry fun create(
        storage_ctx: &mut StorageContext,
        account: &signer,
        name: String,
        unit_price: u128,
    ) {
        let product_created = product_create_logic::verify(
            storage_ctx,
            account,
            name,
            unit_price,
        );
        let product_obj = product_create_logic::mutate(
            storage_ctx,
            &product_created,
        );
        product::set_product_created_id(&mut product_created, product::id(&product_obj));
        product::add_product(storage_ctx, product_obj);
        product::emit_product_created(storage_ctx, product_created);
    }

}
