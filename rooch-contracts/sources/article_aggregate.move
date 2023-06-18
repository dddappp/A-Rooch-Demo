// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module rooch_test_proj1::article_aggregate {
    use moveos_std::object_id::ObjectID;
    use moveos_std::storage_context::StorageContext;
    use rooch_test_proj1::article;
    use rooch_test_proj1::article_add_reference_logic;
    use rooch_test_proj1::article_create_logic;
    use rooch_test_proj1::article_remove_reference_logic;
    use rooch_test_proj1::article_update_reference_logic;
    use rooch_test_proj1::reference_vo;
    use std::option::{Self, Option};
    use std::string::String;
    use std::vector;

    public entry fun create(
        storage_ctx: &mut StorageContext,
        account: &signer,
        title: String,
        author: address,
        content: String,
        references: vector<u8>,
        tags: vector<ObjectID>,
    ) {
        let article_created = article_create_logic::verify(
            storage_ctx,
            account,
            title,
            author,
            content,
            reference_vo::vector_from_bytes(references),
            tags,
        );
        let article_obj = article_create_logic::mutate(
            storage_ctx,
            &article_created,
        );
        article::set_article_created_id(&mut article_created, article::id(&article_obj));
        article::add_article(storage_ctx, article_obj);
        article::emit_article_created(storage_ctx, article_created);
    }


    public entry fun add_reference(
        storage_ctx: &mut StorageContext,
        account: &signer,
        id: ObjectID,
        reference_number: u64,
        title: String,
        url: vector<String>,
    ) {
        let article_obj = article::remove_article(storage_ctx, id);
        let reference_added = article_add_reference_logic::verify(
            storage_ctx,
            account,
            reference_number,
            title,
            vector_to_option(url),
            &article_obj,
        );
        let updated_article_obj = article_add_reference_logic::mutate(
            storage_ctx,
            &reference_added,
            article_obj,
        );
        article::update_version_and_add(storage_ctx, updated_article_obj);
        article::emit_reference_added(storage_ctx, reference_added);
    }


    public entry fun update_reference(
        storage_ctx: &mut StorageContext,
        account: &signer,
        id: ObjectID,
        reference_number: u64,
        title: String,
        url: vector<String>,
        author: vector<String>,
    ) {
        let article_obj = article::remove_article(storage_ctx, id);
        let reference_updated = article_update_reference_logic::verify(
            storage_ctx,
            account,
            reference_number,
            title,
            vector_to_option(url),
            vector_to_option(author),
            &article_obj,
        );
        let updated_article_obj = article_update_reference_logic::mutate(
            storage_ctx,
            &reference_updated,
            article_obj,
        );
        article::update_version_and_add(storage_ctx, updated_article_obj);
        article::emit_reference_updated(storage_ctx, reference_updated);
    }


    public entry fun remove_reference(
        storage_ctx: &mut StorageContext,
        account: &signer,
        id: ObjectID,
        reference_number: u64,
    ) {
        let article_obj = article::remove_article(storage_ctx, id);
        let reference_removed = article_remove_reference_logic::verify(
            storage_ctx,
            account,
            reference_number,
            &article_obj,
        );
        let updated_article_obj = article_remove_reference_logic::mutate(
            storage_ctx,
            &reference_removed,
            article_obj,
        );
        article::update_version_and_add(storage_ctx, updated_article_obj);
        article::emit_reference_removed(storage_ctx, reference_removed);
    }

    fun vector_to_option<V : drop>(v: vector<V>): Option<V> {
        if (vector::length(&v) == 0) { option::none() } else {
            option::some(
                vector::pop_back(&mut v)
            )
        }
    }

}
